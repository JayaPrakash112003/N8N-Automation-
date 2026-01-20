package com.zepto.dto;

import lombok.Data;
import java.util.List;

@Data
public class OrderRequest {
    private List<String> products;
    private String upi_id;
}
