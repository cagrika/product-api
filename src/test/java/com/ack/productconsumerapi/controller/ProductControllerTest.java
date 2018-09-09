package com.ack.productconsumerapi.controller;

import com.ack.productapi.controller.ProductController;
import com.ack.productapi.service.ProductReadService;
import org.apache.http.HttpRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductReadService productReadService;

    @Mock
    private HttpServletRequest request;


    @Test
    public void it_should_get_product(){
        //Given
        //When
        productController.productDetail(request,"productId");
        //Then
        verify(productReadService).getProduct("productId");
    }



}