package com.ack.productapi.converter;

import com.ack.productapi.model.ProductDto;
import com.ack.productapi.repository.model.ProductEntity;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ProductDtoConverter implements Converter<ProductEntity, ProductDto> {

    @Override
    public ProductDto convert(ProductEntity productEntity) {
        return ProductDto.builder()
                .detail(productEntity.getDescription())
                .name(productEntity.getName())
                .id(productEntity.getId())
                .advertiserId(productEntity.getAdvertiserId())
                .createdDate(productEntity.getCreatedDate())
                .likeCount(productEntity.getLikeCount())
                .disLikeCount(productEntity.getDisLikeCount())
                .watchCount(productEntity.getWatchCount())
                .rate(calculateRate(productEntity.getRates()))
                .build();
    }

    private Double calculateRate(Map<String, Long> rates) {
        int totalRate = rates.entrySet().stream().map(rate -> Integer.parseInt(rate.getKey()) * rate.getValue()).mapToInt(Long::intValue).sum();
        int totalVote = rates.entrySet().stream().map(Map.Entry::getValue).mapToInt(Long::intValue).sum();;
        if(totalVote==0) {
            return null;
        }
        return (double) (totalRate / totalVote);
    }
}
