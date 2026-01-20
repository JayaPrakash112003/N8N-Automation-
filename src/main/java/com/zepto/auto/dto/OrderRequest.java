package com.zepto.dto;

import java.util.List;

public class OrderRequest {

    private List<String> products;
    private String upiId;

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
