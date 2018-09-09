package com.ack.productapi.advice.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ProductApiException extends RuntimeException{

    private String detail;
    private int code;

    public ProductApiException(String detail, int code) {
        this.detail = detail;
        this.code = code;
    }
}
