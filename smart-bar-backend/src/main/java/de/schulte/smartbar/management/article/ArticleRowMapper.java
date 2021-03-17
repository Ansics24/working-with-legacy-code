package de.schulte.smartbar.management.article;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import de.schulte.smartbar.management.category.Category;

public class ArticleRowMapper implements RowMapper<Article> {

    @Override
    public Article mapRow(ResultSet rs, int rowNum) throws SQLException {
        Article article = new Article();
        article.setId(rs.getLong("id"));
        article.setName(rs.getString("name"));
        article.setImageUrl(rs.getString("image_url"));
        article.setPrice(rs.getBigDecimal("price"));
        final Category category = new Category();
        category.setId(rs.getLong("category_id"));
        article.setCategory(category);
        return article;
    }

}
