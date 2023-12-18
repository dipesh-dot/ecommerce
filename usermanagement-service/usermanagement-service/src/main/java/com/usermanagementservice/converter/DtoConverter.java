package com.usermanagementservice.converter;


import com.usermanagementservice.dto.AddressDto;
import com.usermanagementservice.dto.UserDto;
import com.usermanagementservice.entity.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DtoConverter {

    public static UserDto convert(User entity, String address){
        if(entity==null)
            return null;
        AddressDto dto1=new AddressDto();
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
       dto.setUsername(entity.getUsername());
       dto.setEmail(entity.getEmail());
       dto.setPhone(entity.getPhone());
       dto.setAddress(address);
        return dto;
    }
//
//
//
//
//
//
//    public static List<UserDto> convertList(List<User> entities, List<String> addresses) {
//        if (entities == null || entities.isEmpty()) {
//            return Collections.emptyList();
//        }
//
//        List<UserDto> dtoList = new ArrayList<>();
//        for (int i = 0; i < entities.size(); i++) {
//            User entity = entities.get(i);
//            String address = (i < addresses.size()) ? addresses.get(i) : null;
//            dtoList.add(convert(entity, address));
//        }
//
//        return dtoList;
//    }
}
