package com.store.ecommerce.service;

import com.store.ecommerce.dto.OrderDto;
import com.store.ecommerce.dto.ProductDto;
import com.store.ecommerce.form.OrderForm;
import com.store.ecommerce.model.Order;
import com.store.ecommerce.model.Product;
import com.store.ecommerce.repository.OrderRepository;
import com.store.ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<OrderDto> findAll() {
        List<Order> list = orderRepository.findAll();
        List<OrderDto> listOrderDto = list.stream().map(OrderDto::new).collect(Collectors.toList());

        return listOrderDto;
    }

    public OrderDto findById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = optional.get();

        return new OrderDto(order);
    }

    public OrderDto insert(OrderForm form) {
        Order order = form.convertToOrder(productRepository);
        order = orderRepository.save(order);

        return new OrderDto(order);
    }
}
