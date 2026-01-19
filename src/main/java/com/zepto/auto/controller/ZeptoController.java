package com.zepto.auto.controller;

import com.zepto.auto.model.ZeptoOrderRequest;
import com.zepto.auto.service.ZeptoOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ZeptoController {

    private final ZeptoOrderService zeptoOrderService;

    public ZeptoController(ZeptoOrderService zeptoOrderService) {
        this.zeptoOrderService = zeptoOrderService;
    }

    @PostMapping("/zepto/order")
    public Map<String, String> orderZepto(@RequestBody ZeptoOrderRequest request) {
        String response = zeptoOrderService.orderProduct(request);
        return Map.of(
                "status", "success",
                "message", response);
    }
}
