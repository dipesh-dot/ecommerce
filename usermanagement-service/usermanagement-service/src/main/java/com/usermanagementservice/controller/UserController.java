package com.usermanagementservice.controller;


import com.usermanagementservice.dto.UserDto;
import com.usermanagementservice.entity.User;
import com.usermanagementservice.generic.CustomResponseMessage;
import com.usermanagementservice.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController

@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;

    }


    @PostMapping("/save")
    ResponseEntity<CustomResponseMessage> userSave(@RequestBody User user) {
        return getGlobalResponse(HttpStatus.CREATED, userService.createUser(user), "User Saved SuccessFully ");
    }

    @GetMapping("/{id}")
    ResponseEntity<CustomResponseMessage> getUserById(@PathVariable Long id) {
        return getGlobalResponse(HttpStatus.FOUND, userService.getByIdUser(id), " user found sucessfully");
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> userDtoList = userService.getAllUsers();
        return ResponseEntity.ok(userDtoList);
    }

    private ResponseEntity<CustomResponseMessage> getGlobalResponse(HttpStatus status, Object data, String message) {
        return ResponseEntity.ok(CustomResponseMessage.builder().status(status).data(data).message(message).build());
    }

}
