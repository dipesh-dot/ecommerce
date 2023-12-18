package com.addressservice.service.implementation;


import com.addressservice.entity.DeliveryAddresses;
import com.addressservice.repository.AddressRepository;
import com.addressservice.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AddressServiceImplementation implements AddressService {

    private final AddressRepository addressRepository;

    public AddressServiceImplementation(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;

    }


    @Override
    public DeliveryAddresses saveAddress(DeliveryAddresses deliveryAddress) {
        return addressRepository.save(deliveryAddress);
    }

    @Override
    public  DeliveryAddresses updatedAddress(Long id,  DeliveryAddresses updatedAddress) {
        return null;
    }

    @Override
    public  DeliveryAddresses getByIdAddress(Long id) {
        return addressRepository.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"Address not found with id : "+id));
    }

    @Override
    public List< DeliveryAddresses> getAllAddress() {
        return addressRepository.findAll();
    }

    @Override
    public boolean deleteAddressById(long id) {
        boolean ans = false;
        addressRepository.deleteById(id);
        ans= true;

        return ans;
    }
}
