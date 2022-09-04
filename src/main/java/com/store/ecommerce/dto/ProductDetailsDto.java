package com.store.ecommerce.dto;

import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class ProductDetailsDto {
    private Long id;

    private String productName;

    private String description;

    private List<Category> categories;

    private String sku;

    private BigDecimal amount;
    
    private Long quantity;

    public ProductDetailsDto() {
    }

    public ProductDetailsDto(Product product, Long quantity) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.categories = product.getCategories();
        this.sku = product.getSku();
        this.amount = product.getAmount();
        this.quantity = quantity;
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

    public Long getQuantity() {
        return quantity;
    }
}
