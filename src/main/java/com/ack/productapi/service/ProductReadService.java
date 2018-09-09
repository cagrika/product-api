package com.ack.productapi.service;

import com.ack.productapi.advice.exception.ProductApiException;
import com.ack.productapi.converter.ProductDtoConverter;
import com.ack.productapi.model.ProductDto;
import com.ack.productapi.repository.ProductRepository;
import com.ack.productapi.repository.model.ProductEntity;
import com.google.common.util.concurrent.RateLimiter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductReadService {

    private final ProductRepository productRepository;
    private final ProductDtoConverter productDtoConverter;

    @Transactional
    public ProductDto getProduct(String productId) {
        log.info("Getting product with id : {}", productId);
        Optional<ProductEntity> productEntity = productRepository.findById(productId);
        if(productEntity.isPresent()) {
            return productDtoConverter.convert(productEntity.get());
        }
        throw new ProductApiException("Product not found for id : " + productId, -99);
    }
        public static void main(String[] args) {
            RateLimiter limiter = RateLimiter.create(3.0);
            for (int i = 0; i < 10; i++) {
                performOperation(limiter);
            }
        }

        private static void performOperation(RateLimiter limiter) {
            limiter.acquire();
            System.out.println(new Date() + ": Beep");
        }

}
