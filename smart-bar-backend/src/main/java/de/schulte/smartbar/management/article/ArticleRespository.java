package de.schulte.smartbar.management.article;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import de.schulte.smartbar.Repository;
import de.schulte.smartbar.management.category.CategoryRespository;

@Component
public class ArticleRespository extends Repository<Article> {

    @Autowired
    private CategoryRespository categoryRespository;

    public ArticleRespository() {
        super("smartbar.article");
    }

    public Article save(Article article) {
        JdbcTemplate template = new JdbcTemplate(dataSource);
        if (article.getId() != null) {
            template.update("update smartbar.article set name=?, image_url=?, price=?, category_id=? where ID=?",
                    article.getName(),
                    article.getImageUrl(), article.getPrice(), article.getCategory().getId(), article.getId());
            return article;
        }
        final long id = getNextId();
        template.update("insert into smartbar.article (id, name, image_url, price, category_id) values (?,?,?,?,?)", id,
                article.getName(), article.getImageUrl(), article.getPrice(), article.getCategory().getId());
        article.setId(id);
        return article;
    }

    @Override
    public List<Article> listAll() {
        final List<Article> articles = super.listAll();
        articles.forEach(article -> article.setCategory(categoryRespository.getById(article.getCategory().getId())));
        return articles;
    }

    @Override
    protected RowMapper<Article> getRowMapper() {
        return new ArticleRowMapper();
    }

    @Override
    protected Class<Article> getManagedClass() {
        return Article.class;
    }
}
