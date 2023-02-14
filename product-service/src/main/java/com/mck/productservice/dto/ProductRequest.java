package com.mck.productservice.dto;

import lombok.*;

import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductRequest {
    private String name;
    private String description;
    private BigDecimal price;
}