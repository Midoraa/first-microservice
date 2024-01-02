package com.test.product_service.entity;

import lombok.Data;

@Data
public class DataResponse {
    private String status;
    private String message;
    private Object result;
}
