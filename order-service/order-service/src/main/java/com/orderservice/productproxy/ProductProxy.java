package com.orderservice.productproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "product",url="http://localhost:8051")
public interface ProductProxy {


    @GetMapping("product/{id}")
    public String getProductName(@PathVariable("id") Long id);
}
