package com.store.ecommerce.form;

import com.store.ecommerce.model.Category;
import com.sun.istack.NotNull;

public class CategoryForm {

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
