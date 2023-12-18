package com.orderservice.productproxy;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;


@FeignClient(value = "product",url="http://localhost:8051")
public interface ProductServiceClient {


    @GetMapping("/product/price/{id}")
    public double getProductPrice(@PathVariable Long id) ;



}
