package com.addressservice.controller;



import com.addressservice.dto.AddressDto;
import com.addressservice.entity.DeliveryAddresses;
import com.addressservice.generic.CustomResponseMessage;
import com.addressservice.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }


    @PostMapping("/save")
    ResponseEntity<CustomResponseMessage> SaveaC(@RequestBody DeliveryAddresses deliveryaddress){
        return getGlobalResponse(HttpStatus.CREATED,addressService.saveAddress(deliveryaddress),"Address Saved SuccessFully ");
    }



    @GetMapping("/{id}")
    ResponseEntity<CustomResponseMessage> getAddressById(@PathVariable Long id){
        return getGlobalResponse(HttpStatus.FOUND,addressService.getByIdAddress(id),"Address  found  ");
    }



    @GetMapping("/all")
    ResponseEntity<CustomResponseMessage> getAll(){
        return getGlobalResponse(HttpStatus.FOUND,addressService.getAllAddress(),"All Address found  ");
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<CustomResponseMessage> deleteAddress(@PathVariable Long id ){
        return getGlobalResponse(HttpStatus.OK,addressService.deleteAddressById(id),"Address deleted by id   ");
    }



    private ResponseEntity<CustomResponseMessage> getGlobalResponse(HttpStatus status, Object data, String message) {
        return ResponseEntity.ok(CustomResponseMessage.builder().status(status).data(data).message(message).build());
    }

}
