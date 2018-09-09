package com.ack.productapi.controller;

import com.ack.productapi.aspect.RateLimit;
import com.ack.productapi.service.ProductReadService;
import com.ack.productapi.model.ProductDto;
import com.google.common.util.concurrent.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping("/product")
public class ProductController {

    private final ProductReadService productReadService;

    @GetMapping(path = "/{productId}")
    @ResponseStatus(HttpStatus.OK)
    @RateLimit(limit = 3, duration = 60, unit = TimeUnit.SECONDS)
    public ProductDto productDetail(HttpServletRequest request, @PathVariable("productId") final String productId){
        return productReadService.getProduct(productId);
    }


}

