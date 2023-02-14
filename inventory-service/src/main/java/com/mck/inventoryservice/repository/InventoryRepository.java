package com.mck.inventoryservice.repository;

import com.mck.inventoryservice.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findBySkuCode(String skuCode);
    List<Inventory> findBySkuCodeIn(List<String> skuCode);
}
