package de.schulte.smartbar.management.article;

import java.math.BigDecimal;

import de.schulte.smartbar.Entity;
import de.schulte.smartbar.management.category.Category;

public class Article extends Entity {

    private String name;

    private String imageUrl;

    private BigDecimal price;
    
    private Category article;

    public static Article fromDto(ArticleDto articleDto) {
        Article article = new Article();
        article.setId(articleDto.getId());
        article.setName(articleDto.getName());
        article.setPrice(articleDto.getPrice());
        article.setImageUrl(articleDto.getImageUrl());
        article.setCategory(Category.fromDto(articleDto.getCategory()));
        return article;
    }

    public ArticleDto toDto() {
        ArticleDto dto = new ArticleDto();
        dto.setId(getId());
        dto.setName(getName());
        dto.setPrice(getPrice());
        dto.setImageUrl(getImageUrl());
        dto.setCategory(getCategory().toDto());
        return dto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Category getCategory() {
        return article;
    }

    public void setCategory(Category article) {
        this.article = article;
    }
}
