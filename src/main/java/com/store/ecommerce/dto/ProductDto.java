package com.store.ecommerce.dto;

import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class ProductDto implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;

    private String productName;

    private String description;

    private List<Category> categories;

    private String sku;

    private BigDecimal amount;

    public ProductDto() {
    }

    public ProductDto(Product product) {
        this.id = product.getId();
        this.productName = product.getProductName();
        this.description = product.getDescription();
        this.categories = product.getCategories();
        this.sku = product.getSku();
        this.amount = product.getAmount();
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

    public BigDecimal getAmount() {
        return amount;
    }
}
