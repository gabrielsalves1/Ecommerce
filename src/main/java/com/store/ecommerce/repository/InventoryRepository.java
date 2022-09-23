package com.store.ecommerce.repository;

import com.store.ecommerce.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    Long countByProduct_Id(Long id);

    @Query(value = "SELECT * FROM tb_inventory WHERE product_id = :id AND order_id IS NULL ORDER BY id ASC LIMIT 1", nativeQuery = true)
    Inventory findInventoryByProductIdWithoutOrderId(@Param("id") Long id);
}
