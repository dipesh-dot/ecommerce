package com.usermanagementservice.service;


import com.usermanagementservice.dto.UserDto;
import com.usermanagementservice.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User createUser(User user);

    UserDto getByIdUser(Long id);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
