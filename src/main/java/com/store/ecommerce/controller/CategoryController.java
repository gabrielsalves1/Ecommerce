package com.store.ecommerce.controller;

import com.store.ecommerce.dto.CategoryDto;
import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.CategoryForm;
import com.store.ecommerce.form.ProductForm;
import com.store.ecommerce.service.CategoryService;
import com.store.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> findAll() {
        List<CategoryDto> listCategoryDto = categoryService.findAll();

        return listCategoryDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        CategoryDto categoryDto = categoryService.findById(id);

        return ResponseEntity.ok().body(categoryDto);
    }

    @PostMapping
    public ResponseEntity<CategoryDto> insert(@RequestBody CategoryForm form, UriComponentsBuilder uriBuilder) {
        CategoryDto categoryDto = categoryService.insert(form);
        URI uri = uriBuilder.path("/categories/{id}").buildAndExpand(categoryDto.getId()).toUri();

        return ResponseEntity.created(uri).body(categoryDto);
    }
}
