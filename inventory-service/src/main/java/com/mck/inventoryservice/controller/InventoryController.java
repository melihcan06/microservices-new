package com.mck.inventoryservice.controller;

import com.mck.inventoryservice.dto.*;
import com.mck.inventoryservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    public final InventoryService inventoryService;

    @GetMapping("/isInStock2/{sku-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock2(@PathVariable("sku-code") String skuCode){
        return inventoryService.isInStock2(skuCode);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> isInStock(@RequestParam List<String> skuCode){
        return inventoryService.isInStock(skuCode);
    }

}
