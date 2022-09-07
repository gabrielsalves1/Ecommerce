package com.store.ecommerce.form;

import com.store.ecommerce.model.Category;
import com.store.ecommerce.model.Order;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.CategoryRepository;
import com.store.ecommerce.repository.ProductRepository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderForm implements Serializable {
    public static final long serialVersionUID = 1L;

    private List<Long> productsId;

    private String address;

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Order convertToOrder(ProductRepository productRepository) {
        List<Product> list = new ArrayList<>();
        productsId.stream().forEach(id ->
                list.add(productRepository.findById(id).get())
        );
        return new Order(list, address);
    }
}
