package com.ack.productapi.advice.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class RateLimitException extends RuntimeException {

    private String detail;
    private int code;

    public RateLimitException(String detail, int code){
        this.code = code;
        this.detail = detail;
    }
}
