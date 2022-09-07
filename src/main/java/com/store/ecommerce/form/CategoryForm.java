package com.store.ecommerce.form;

import com.store.ecommerce.model.Category;
import com.sun.istack.NotNull;

import java.io.Serializable;

public class CategoryForm implements Serializable {
    public static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category convertToCategory() {
        return new Category(name);
    }
}
