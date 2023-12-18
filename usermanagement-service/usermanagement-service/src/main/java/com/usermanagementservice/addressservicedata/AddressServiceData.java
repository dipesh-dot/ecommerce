package com.usermanagementservice.addressservicedata;


import com.usermanagementservice.addressproxy.AddressProxy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AddressServiceData {

    private  final AddressProxy addressProxy;

    public String getAddressById(Long id){

        return addressProxy.getAddressById(id);
    }
}
