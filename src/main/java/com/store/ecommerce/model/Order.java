package com.store.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.store.ecommerce.enums.ORDER_STATUS;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity(name = "tb_order")
public class Order {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "tb_order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products;

    @Enumerated(EnumType.STRING)
    private ORDER_STATUS status = ORDER_STATUS.PROCESSAMENTO;

    @OneToOne
    private User user;

    private BigDecimal amount;

    @OneToMany
    @JsonIgnore
    private List<Inventory> inventories;

    public Order() {
    }

    public Order(List<Product> products, User user) {
        this.products = products;
        this.user = user;

        this.amount = products.stream().map(Product::getAmount).reduce(BigDecimal::add).get();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ORDER_STATUS getStatus() {
        return status;
    }

    public void setStatus(ORDER_STATUS status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<Inventory> getInventories() {
        return inventories;
    }

    public void setInventories(List<Inventory> inventories) {
        this.inventories = inventories;
    }
}
