package com.zepto.controller;

import com.zepto.dto.OrderRequest;
import com.zepto.service.ZeptoAutomationService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final ZeptoAutomationService service;

    public OrderController(ZeptoAutomationService service) {
        this.service = service;
    }

    @PostMapping
    public Map<String, Object> placeOrder(@RequestBody OrderRequest request) {

        String product = request.getProducts().get(0);
        service.addToCart(product);

        return Map.of(
                "status", "success",
                "product", product,
                "upi_id", request.getUpi_id()
        );
    }

    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
