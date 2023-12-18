package com.usermanagementservice.addressproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Component
@FeignClient(value = "address",url = "http://localhost:8050")
public interface AddressProxy {


    @GetMapping("address/{id}")
    String getAddressById(@PathVariable Long id);


//    @GetMapping("/all")
//    List<String> getAddresses();
}
