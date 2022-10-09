package com.store.ecommerce.dto;

import com.store.ecommerce.enums.ORDER_STATUS;
import com.store.ecommerce.model.Inventory;
import com.store.ecommerce.model.Order;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.model.User;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class OrderDto implements Serializable {
    public static final long serialVersionUID = 1L;

    private Long id;

    private List<Product> products;

    private ORDER_STATUS status;

    private UserDto user;

    private BigDecimal amount;

    private List<Inventory> inventories;

    public OrderDto() {
    }

    public OrderDto(Order order) {
        this.id = order.getId();
        this.products = order.getProducts();
        this.status = order.getStatus();
        this.user = new UserDto(order.getUser());
        this.amount = order.getAmount();
        this.inventories = order.getInventories();
    }

    public Long getId() {
        return id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public ORDER_STATUS getStatus() {
        return status;
    }

    public UserDto getUser() {
        return user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }
}
