package com.mck.inventoryservice.service;

import com.mck.inventoryservice.dto.*;
import com.mck.inventoryservice.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;

import java.util.*;

import static java.util.stream.Collectors.toList;

@Service
@RequiredArgsConstructor
public class InventoryService {

    public final InventoryRepository inventoryRepository;

    @Transactional(readOnly = true)
    public boolean isInStock2(String skuCode) {
        return inventoryRepository.findBySkuCode(skuCode).isPresent();
    }

    @Transactional(readOnly = true)
    public List<InventoryResponse> isInStock(List<String> skuCode) {
        return inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                        InventoryResponse.builder()
                                .skuCode(inventory.getSkuCode())
                                .isInStock(inventory.getQuantity() > 0)
                                .build()
                ).toList();
    }
}
