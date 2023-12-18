package com.orderservice.userproxy;

import feign.FeignException;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "usermanagement",url = "http://localhost:8052")
public interface UserProxy {


    @GetMapping("user/{id}")
    String getUser(@PathVariable("id") Long id) throws FeignException;
}
