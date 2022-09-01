package com.store.ecommerce.service;

import com.store.ecommerce.dto.CategoryDto;
import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.CategoryForm;
import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> findAll() {
        List<Category> list = categoryRepository.findAll();
        List<CategoryDto> listCategoryDto = list.stream().map(CategoryDto::new).collect(Collectors.toList());

        return listCategoryDto;
    }

    public CategoryDto findById(Long id) {
        Optional<Category> optional = categoryRepository.findById(id);
        Category category = optional.get();

        CategoryDto categoryDto = new CategoryDto(category);
        return categoryDto;
    }


    public CategoryDto insert(CategoryForm form) {
        Category category = form.convertToCategory();
        category = categoryRepository.save(category);

        return new CategoryDto(category);
    }
}
