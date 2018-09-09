package com.ack.productconsumerapi.service;

import com.ack.productapi.converter.ProductDtoConverter;
import com.ack.productapi.model.ProductDto;
import com.ack.productapi.repository.ProductRepository;
import com.ack.productapi.repository.model.ProductEntity;
import com.ack.productapi.service.ProductReadService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductReadServiceTest {

    @InjectMocks
    private ProductReadService productReadService;

    @Mock
    private ProductRepository productRepository;

    @Mock
    private ProductDtoConverter productDtoConverter;

    @Test
    public void it_should_get_product() {
        //Given
        ProductEntity productEntity = new ProductEntity();
        when(productRepository.findById("productId")).thenReturn(Optional.of(productEntity));
        ProductDto productDto = ProductDto.builder().build();
        when(productDtoConverter.convert(productEntity)).thenReturn(productDto);
        //When
        ProductDto result = productReadService.getProduct("productId");
        //Then
        assertThat(result).isEqualTo(productDto);
    }

}