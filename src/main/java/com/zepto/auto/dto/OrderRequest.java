package com.zepto.dto;

import java.util.List;

public class OrderRequest {

    private List<String> products;
    private String upi_id;

    public List<String> getProducts() {
        return products;
    }

    public void setProducts(List<String> products) {
        this.products = products;
    }

    public String getUpi_id() {
        return upi_id;
    }

    public void setUpi_id(String upi_id) {
        this.upi_id = upi_id;
    }
}
