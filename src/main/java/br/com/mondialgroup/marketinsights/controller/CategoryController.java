package br.com.mondialgroup.marketinsights.controller;

import br.com.mondialgroup.marketinsights.dto.request.CategoryListRequest;
import br.com.mondialgroup.marketinsights.dto.request.CategoryRequest;
import br.com.mondialgroup.marketinsights.dto.response.CategoryResponse;
import br.com.mondialgroup.marketinsights.mapper.CategoryMapper;
import br.com.mondialgroup.marketinsights.model.Category;
import br.com.mondialgroup.marketinsights.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/categories")
@RequiredArgsConstructor  // delegando ao Spring a responsabilidade de criar o construtor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryResponse> saveCategory(@Valid @RequestBody CategoryRequest request) {
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.save(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(savedCategory));
    }

    @PostMapping("/batch")
    ResponseEntity<List<CategoryResponse>> saveAllCategories(@Valid @RequestBody CategoryListRequest request) {
        List<Category> categories = request.categories().stream()
                .map(CategoryMapper::toCategory)
                .toList();
        List<CategoryResponse> newCategories = categoryService.saveAll(categories).stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategories);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories() {
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getByCategoryId(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteByCategoryId(@PathVariable Long id) {
        Optional<Category> category = categoryService.findById(id);
        if (category.isPresent()) {
            categoryService.delete(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.notFound().build();
    }
}
