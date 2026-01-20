package com.zepto.auto.controller;

import com.zepto.dto.OrderRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @PostMapping
    public String placeOrder(@RequestBody OrderRequest request) {

        System.out.println("Products: " + request.getProducts());
        System.out.println("UPI ID: " + request.getUpiId());

        return "Order placed successfully";
    }
}
