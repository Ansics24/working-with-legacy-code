package de.schulte.smartbar.management.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping(consumes = "application/json")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        final CategoryDto resultingDto = categoryService.saveCategory(categoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(resultingDto);
    }

    @PutMapping(consumes = "application/json")
    public ResponseEntity<CategoryDto> updateCategory(CategoryDto categoryDto) {
        final CategoryDto resultingDto = categoryService.saveCategory(categoryDto);
        return ResponseEntity.ok(resultingDto);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> list() {
        return ResponseEntity.ok(categoryService.listAll());
    }

}
