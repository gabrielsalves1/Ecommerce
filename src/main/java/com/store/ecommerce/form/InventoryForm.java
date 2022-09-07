package com.store.ecommerce.form;

import com.store.ecommerce.model.Inventory;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.InventoryRepository;
import com.store.ecommerce.repository.ProductRepository;
import com.sun.istack.NotNull;

import java.io.Serializable;

public class InventoryForm implements Serializable {
    public static final long serialVersionUID = 1L;

    @NotNull
    private Long productId;

    private String productCode;


    public Long getProductId() {
        return productId;
    }

    public String getProductCode() {
        return productCode;
    }

    public Inventory convertToInventory(ProductRepository productRepository) {
        return new Inventory(productRepository.findById(productId).get(), productCode);
    }
}
