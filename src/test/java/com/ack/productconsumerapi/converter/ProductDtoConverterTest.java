package com.ack.productconsumerapi.converter;

import com.ack.productapi.converter.ProductDtoConverter;
import com.ack.productapi.model.ProductDto;
import com.ack.productapi.repository.model.ProductEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.HashMap;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(MockitoJUnitRunner.class)
public class ProductDtoConverterTest {

    @InjectMocks
    private ProductDtoConverter productDtoConverter;

    @Test
    public void it_should_convert_product_entity_to_dto() {
        //Given
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId("id");
        productEntity.setAdvertiserId("advertiserId");
        productEntity.setName("name");
        productEntity.setDescription("description");
        productEntity.setRates(new HashMap<>());
        productEntity.setLikeCount(100);
        productEntity.setDisLikeCount(200);
        productEntity.setWatchCount(300);
        //When
        ProductDto productDto = productDtoConverter.convert(productEntity);
        //Then
        assertThat(productDto.getDetail()).isEqualTo("description");
        assertThat(productDto.getName()).isEqualTo("name");
        assertThat(productDto.getId()).isEqualTo("id");
        assertThat(productDto.getAdvertiserId()).isEqualTo("advertiserId");
        assertThat(productDto.getLikeCount()).isEqualTo(100);
        assertThat(productDto.getWatchCount()).isEqualTo(300);
        assertThat(productDto.getDisLikeCount()).isEqualTo(200);
        assertThat(productDto.getRate()).isEqualTo(null);
    }
}