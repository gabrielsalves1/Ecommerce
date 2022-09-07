package com.store.ecommerce.service;

import com.store.ecommerce.dto.OrderDto;
import com.store.ecommerce.form.OrderForm;
import com.store.ecommerce.model.Order;
import com.store.ecommerce.repository.OrderRepository;
import com.store.ecommerce.repository.ProductRepository;
import com.store.ecommerce.service.exceptions.OrderNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<OrderDto> findAll() {
        List<Order> list = orderRepository.findAll();
        List<OrderDto> listOrderDto = list.stream().map(OrderDto::new).collect(Collectors.toList());

        return listOrderDto;
    }

    @Transactional(readOnly = true)
    public OrderDto findById(Long id) {
        Optional<Order> optional = orderRepository.findById(id);
        Order order = optional.orElseThrow(() -> new OrderNotFoundException("Order not found"));

        return new OrderDto(order);
    }

    @Transactional
    public OrderDto insert(OrderForm form) {
        Order order = form.convertToOrder(productRepository);
        order = orderRepository.save(order);

        return new OrderDto(order);
    }
}
