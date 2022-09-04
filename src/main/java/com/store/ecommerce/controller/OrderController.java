package com.store.ecommerce.controller;

import com.store.ecommerce.dto.InventoryDto;
import com.store.ecommerce.dto.OrderDto;
import com.store.ecommerce.form.InventoryForm;
import com.store.ecommerce.form.OrderForm;
import com.store.ecommerce.service.InventoryService;
import com.store.ecommerce.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<OrderDto> findAll() {
        List<OrderDto> listOrderDto = orderService.findAll();

        return listOrderDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable Long id) {
        OrderDto orderDto = orderService.findById(id);

        return ResponseEntity.ok().body(orderDto);
    }

    @PostMapping
    public ResponseEntity<OrderDto> insert(@RequestBody OrderForm form, UriComponentsBuilder uriBuilder) {
        OrderDto orderDto = orderService.insert(form);
        URI uri = uriBuilder.path("/orders/{id}").buildAndExpand(orderDto.getId()).toUri();

        return ResponseEntity.created(uri).body(orderDto);
    }
}
