package com.zepto.auto.model;

public class ZeptoOrderRequest {

    private String productName;
    private String quantity;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    private String upiId;

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getUpiId() {
        return upiId;
    }

    public void setUpiId(String upiId) {
        this.upiId = upiId;
    }
}
