package com.mck.orderservice.dto;

import lombok.*;

import java.math.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderLineItemsDto {
    private Long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
