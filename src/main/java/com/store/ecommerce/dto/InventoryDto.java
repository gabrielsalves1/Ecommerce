package com.store.ecommerce.dto;

import com.store.ecommerce.model.Inventory;
import com.store.ecommerce.model.Product;

import java.io.Serializable;

public class InventoryDto implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;

    private Product product;

    private String productCode;

    public InventoryDto() {
    }

    public InventoryDto(Inventory inventory) {
        this.id = inventory.getId();
        this.product = inventory.getProduct();
        this.productCode = inventory.getProductCode();
    }

    public Long getId() {
        return id;
    }

    public Product getProduct() {
        return product;
    }

    public String getProductCode() {
        return productCode;
    }
}
