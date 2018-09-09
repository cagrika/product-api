package com.ack.productapi.advice;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {

    private String exception;
    private int code;
}
