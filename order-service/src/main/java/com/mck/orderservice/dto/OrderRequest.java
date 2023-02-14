package com.mck.orderservice.dto;

import lombok.*;

import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderRequest {
    private List<OrderLineItemsDto> orderLineItemsDtoList;
}
