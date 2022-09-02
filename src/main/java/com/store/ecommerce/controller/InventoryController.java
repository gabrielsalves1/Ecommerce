package com.store.ecommerce.controller;

import com.store.ecommerce.dto.CategoryDto;
import com.store.ecommerce.dto.InventoryDto;
import com.store.ecommerce.form.InventoryForm;
import com.store.ecommerce.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryDto> findAll() {
        List<InventoryDto> listInventoryDto = inventoryService.findAll();

        return listInventoryDto;
    }

    @GetMapping("/{id}")
    public ResponseEntity<InventoryDto> findById(@PathVariable Long id) {
        InventoryDto inventoryDto = inventoryService.findById(id);

        return ResponseEntity.ok().body(inventoryDto);
    }

    @PostMapping
    public ResponseEntity<InventoryDto> insert(@RequestBody InventoryForm form, UriComponentsBuilder uriBuilder) {
        InventoryDto inventoryDto = inventoryService.insert(form);
        URI uri = uriBuilder.path("/inventories/{id}").buildAndExpand(inventoryDto.getId()).toUri();

        return ResponseEntity.created(uri).body(inventoryDto);
    }
}
