package com.ack.productapi.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Setter
@Getter
@Builder
public class ProductDto {

    private String id;
    private String name;
    private String creatorUser;
    private String detail;
    private String advertiserId;
    private Date createdDate;
    private Integer likeCount;
    private Integer disLikeCount;
    private Double rate;
    private Integer watchCount;

}
