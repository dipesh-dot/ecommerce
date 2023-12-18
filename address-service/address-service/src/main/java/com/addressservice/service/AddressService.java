package com.addressservice.service;



import com.addressservice.entity.DeliveryAddresses;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AddressService {

    DeliveryAddresses saveAddress(DeliveryAddresses   deliveryAddress);
    DeliveryAddresses updatedAddress(Long id,  DeliveryAddresses updatedAddress);
    DeliveryAddresses getByIdAddress(Long id);
    List< DeliveryAddresses> getAllAddress();
    boolean deleteAddressById(long id);
}
