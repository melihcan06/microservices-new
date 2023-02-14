package com.mck.orderservice.service;

import com.mck.orderservice.constants.*;
import com.mck.orderservice.dto.*;
import com.mck.orderservice.model.*;
import com.mck.orderservice.repository.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.reactive.function.client.*;

import java.util.*;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final WebClient webClient;//Bean olarak verdigimiz method WebClientConfig deki

    public void placeOrder(OrderRequest orderRequest){
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();
        order.setOrderLineItemsList(orderLineItems);

        List<String> skuCodes = order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();

        //TODO Call Inventory Service and place order if producrt is in stock
        InventoryResponse[] inventoryResponseArray = webClient.get()
                .uri(Constants.INVENTORY_URI,
                        uriBuilder -> uriBuilder.queryParam("skuCode", skuCodes).build())
                .retrieve()
                .bodyToMono(InventoryResponse[].class)
                .block();

        boolean allProductsInStock = Arrays.stream(inventoryResponseArray).allMatch(InventoryResponse::isInStock);

        if(allProductsInStock){
            orderRepository.save(order);
        } else {
            throw  new IllegalArgumentException("Product is not in stock, please try again later");
        }
    }

    private OrderLineItems mapToDto(OrderLineItemsDto orderLineItemsDto) {
        OrderLineItems orderLineItems = new OrderLineItems();
        orderLineItems.setPrice(orderLineItemsDto.getPrice());
        orderLineItems.setQuantity(orderLineItemsDto.getQuantity());
        orderLineItems.setSkuCode(orderLineItemsDto.getSkuCode());
        return orderLineItems;
    }
}
