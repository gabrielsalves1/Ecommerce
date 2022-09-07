package com.store.ecommerce.service.exceptions;

public class InventoryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public InventoryNotFoundException(String msg) {
        super(msg);
    }
}
