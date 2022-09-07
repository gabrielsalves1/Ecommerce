package com.store.ecommerce.service;

import com.store.ecommerce.dto.InventoryDto;
import com.store.ecommerce.form.InventoryForm;
import com.store.ecommerce.model.Inventory;
import com.store.ecommerce.repository.InventoryRepository;
import com.store.ecommerce.repository.ProductRepository;
import com.store.ecommerce.service.exceptions.InventoryNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public List<InventoryDto> findAll() {
        List<Inventory> list = inventoryRepository.findAll();
        List<InventoryDto> listInventoryDto = list.stream().map(InventoryDto::new).collect(Collectors.toList());

        return listInventoryDto;
    }

    @Transactional
    public InventoryDto insert(InventoryForm form) {
        Inventory inventory = form.convertToInventory(productRepository);
        inventory = inventoryRepository.save(inventory);

        return new InventoryDto(inventory);
    }

    @Transactional(readOnly = true)
    public InventoryDto findById(Long id) {
        Optional<Inventory> optional = inventoryRepository.findById(id);
        Inventory inventory = optional.orElseThrow(() -> new InventoryNotFoundException("Inventory not found"));

        return new InventoryDto(inventory);
    }
}
