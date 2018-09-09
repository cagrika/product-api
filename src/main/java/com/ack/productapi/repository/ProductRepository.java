package com.ack.productapi.repository;

import com.ack.productapi.repository.model.ProductEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ProductRepository extends CrudRepository<ProductEntity, String> {


}
