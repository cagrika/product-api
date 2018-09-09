package com.ack.productapi.advice;

import com.ack.productapi.advice.exception.ProductApiException;
import com.ack.productapi.advice.exception.RateLimitException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
@Slf4j
public class ProductApiExceptionHandler {

    @ExceptionHandler(value = { Exception.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse unknownException(Exception ex) {
        log.error(ex.getMessage());
        return ErrorResponse.builder()
                .exception(ex.getLocalizedMessage())
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .build();
    }

    @ExceptionHandler(value = { ProductApiException.class})
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse productConsumerException(ProductApiException ex) {
        log.error(ex.getDetail());
        return ErrorResponse.builder()
                .exception(ex.getDetail())
                .code(ex.getCode())
                .build();
    }

    @ExceptionHandler(value = { RateLimitException.class})
    @ResponseStatus(HttpStatus.TOO_MANY_REQUESTS)
    @ResponseBody
    public ErrorResponse rateLimitException(RateLimitException ex) {
        log.error(ex.getDetail());
        return ErrorResponse.builder()
                .exception(ex.getDetail())
                .code(ex.getCode())
                .build();
    }

}
