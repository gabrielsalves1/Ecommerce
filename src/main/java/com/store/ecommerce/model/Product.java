package com.store.ecommerce.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "tb_product")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productName;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "tb_product_categories",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<Category> categories;

    private String sku;

    private BigDecimal amount;

    public Product() {
    }

    public Product(String productName, String description, List<Category> categories, String sku, BigDecimal amount) {
        this.productName = productName;
        this.description = description;
        this.categories = categories;
        this.sku = sku;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
