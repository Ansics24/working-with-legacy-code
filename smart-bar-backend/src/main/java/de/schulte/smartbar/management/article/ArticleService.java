package de.schulte.smartbar.management.article;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ArticleService {

    @Autowired
    private ArticleRespository articleRespository;

    public ArticleDto saveArticle(ArticleDto articleDto) {
        final Article article = articleRespository.save(Article.fromDto(articleDto));
        return article.toDto();
    }

    public List<ArticleDto> listAll() {
        return articleRespository.listAll().stream().map(c ->c.toDto()).collect(Collectors.toList());
    }

}
