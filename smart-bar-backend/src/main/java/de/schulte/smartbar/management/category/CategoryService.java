package de.schulte.smartbar.management.category;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CategoryService {

    @Autowired
    private CategoryRespository categoryRespository;

    public CategoryDto saveCategory(CategoryDto categoryDto) {
        final Category category = categoryRespository.save(Category.fromDto(categoryDto));
        return category.toDto();
    }

    public List<CategoryDto> listAll() {
        return categoryRespository.listAll().stream().map(c ->c.toDto()).collect(Collectors.toList());
    }

}
