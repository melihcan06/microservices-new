package com.mck.orderservice.controller;

import com.mck.orderservice.dto.*;
import com.mck.orderservice.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody OrderRequest orderRequest){
        orderService.placeOrder(orderRequest);
        return "Order Placed Successfully";
    }
}
