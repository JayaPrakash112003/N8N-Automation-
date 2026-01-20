package com.zepto.controller;

import com.zepto.dto.OrderRequest;
import com.zepto.service.ZeptoPlaywrightService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final ZeptoPlaywrightService service;

    public OrderController(ZeptoPlaywrightService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {

        service.placeOrder(
                request.getProducts(),
                request.getUpi_id()
        );

        return ResponseEntity.ok().body(
                java.util.Map.of(
                        "status", "success",
                        "products", request.getProducts(),
                        "upi", request.getUpi_id()
                )
        );
    }
}
