package com.store.ecommerce.controller;

import com.store.ecommerce.dto.ProductDetailsDto;
import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.ProductForm;
import com.store.ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Page<ProductDto> findAll(@PageableDefault(sort = "id", direction = Sort.Direction.ASC, page = 0, size = 10) Pageable pageable) {

        Page<ProductDto> listProductDto = productService.findAll(pageable);

        return listProductDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDetailsDto> findById(@PathVariable Long id) {
        ProductDetailsDto productDetailsDto = productService.findById(id);

        return ResponseEntity.ok().body(productDetailsDto);
    }

    @PostMapping
    public ResponseEntity<ProductDto> insert(@RequestBody ProductForm form, UriComponentsBuilder uriBuilder) {
        ProductDto productDto = productService.insert(form);
        URI uri = uriBuilder.path("/products/{id}").buildAndExpand(productDto.getId()).toUri();

        return ResponseEntity.created(uri).body(productDto);
    }
}
