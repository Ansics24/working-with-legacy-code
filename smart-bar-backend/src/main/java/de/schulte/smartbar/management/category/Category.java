package de.schulte.smartbar.management.category;

import de.schulte.smartbar.Entity;

public class Category extends Entity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Category fromDto(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.getId());
        category.setName(categoryDto.getName());
        return category;
    }

    public CategoryDto toDto() {
        CategoryDto dto = new CategoryDto();
        dto.setId(getId());
        dto.setName(getName());
        return dto;
    }
}
