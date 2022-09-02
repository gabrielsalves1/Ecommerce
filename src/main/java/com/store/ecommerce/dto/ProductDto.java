package com.store.ecommerce.dto;

import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Product;

import java.util.List;

public class ProductDto {

    private Long id;

    private String productName;

    private String description;

    private List<Category> categories;

    private String sku;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.categories = product.getCategories();
        this.sku = product.getSku();
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getDescription() {
        return description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public String getSku() {
        return sku;
    }
}
