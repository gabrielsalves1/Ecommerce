package com.store.ecommerce.service;

import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.ProductForm;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.CategoryRepository;
import com.store.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    public List<ProductDto> findAll() {
        List<Product> list = productRepository.findAll();
        List<ProductDto> listDto = list.stream().map(ProductDto::new).collect(Collectors.toList());

        return listDto;
    }

    public ProductDto findById(Long id) {
        Optional<Product> optional = productRepository.findById(id);
        Product product = optional.get();

        ProductDto productDto = new ProductDto(product);
        return productDto;
    }

    @Transactional
    public ProductDto insert(ProductForm form) {
        Product product = form.convertToProduct(categoryRepository);
        product = productRepository.save(product);

        return new ProductDto(product);
    }

}
