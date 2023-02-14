package com.mck.productservice.dto;

import lombok.*;

import java.math.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class ProductResponse {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
}
