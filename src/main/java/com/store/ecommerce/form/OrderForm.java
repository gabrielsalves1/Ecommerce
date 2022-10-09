package com.store.ecommerce.form;

import com.store.ecommerce.model.*;
import com.store.ecommerce.repository.CategoryRepository;
import com.store.ecommerce.repository.InventoryRepository;
import com.store.ecommerce.repository.ProductRepository;
import com.store.ecommerce.repository.UserRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderForm implements Serializable {
    public static final long serialVersionUID = 1L;

    private List<Long> productsId;

    private Long userId;

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Order convertToOrder(ProductRepository productRepository, InventoryRepository inventoryRepository, UserRepository userRepository) {
        List<Product> list = new ArrayList<>();
        User user = userRepository.findById(userId).get();

        productsId.stream().forEach(id -> {
            list.add(productRepository.findById(id).get());
        });

        return new Order(list, user);
    }
}
