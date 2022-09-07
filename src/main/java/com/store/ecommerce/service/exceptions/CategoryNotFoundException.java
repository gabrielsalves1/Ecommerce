package com.store.ecommerce.service.exceptions;

public class CategoryNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public CategoryNotFoundException(String msg) {
        super(msg);
    }
}
