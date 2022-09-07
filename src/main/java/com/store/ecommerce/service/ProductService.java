package com.store.ecommerce.service;

import com.store.ecommerce.dto.ProductDetailsDto;
import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.ProductForm;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.CategoryRepository;
import com.store.ecommerce.repository.InventoryRepository;
import com.store.ecommerce.repository.ProductRepository;
import com.store.ecommerce.service.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public Page<ProductDto> findAll(Pageable pageable) {
        Page<Product> list = productRepository.findAll(pageable);
        Page<ProductDto> listDto = list.map(ProductDto::new);

        return listDto;
    }

    @Transactional(readOnly = true)
    public ProductDetailsDto findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.orElseThrow(() -> new ProductNotFoundException("Product not found"));
        Long quantity = inventoryRepository.countByProduct_Id(product.getId());

        ProductDetailsDto productDetailsDto = new ProductDetailsDto(product, quantity);
        return productDetailsDto;
    }

    @Transactional
    public ProductDto insert(ProductForm form) {
        Product product = form.convertToProduct(categoryRepository);
        product = productRepository.save(product);

        return new ProductDto(product);
    }
}
