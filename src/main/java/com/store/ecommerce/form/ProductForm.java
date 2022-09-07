package com.store.ecommerce.form;

import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.CategoryRepository;
import com.sun.istack.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductForm implements Serializable {
    public static final long serialVersionUID = 1L;

    @NotNull
    private String productName;

    @NotNull
    private String description;

    private List<Long> categoriesId;

    @NotNull
    private String sku;

    @NotNull
    private BigDecimal amount;

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

    public List<Long> getCategoriesId() {
        return categoriesId;
    }

    public void setCategoriesId(List<Long> categoriesId) {
        this.categoriesId = categoriesId;
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

    public Product convertToProduct(CategoryRepository categoryRepository) {
        List<Category> list = new ArrayList<>();
        categoriesId.stream().forEach(id ->
                list.add(categoryRepository.findById(id).get())
        );
        return new Product(productName, description, list, sku, amount);
    }
}
