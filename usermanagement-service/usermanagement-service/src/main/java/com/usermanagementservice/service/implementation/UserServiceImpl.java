package com.usermanagementservice.service.implementation;

import com.usermanagementservice.addressproxy.AddressProxy;
import com.usermanagementservice.converter.DtoConverter;
import com.usermanagementservice.dto.UserDto;
import com.usermanagementservice.entity.User;
import com.usermanagementservice.repository.UserRepository;
import com.usermanagementservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    private final AddressProxy addressProxy;
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl
            (AddressProxy addressProxy, UserRepository userRepository) {
        this.addressProxy = addressProxy;
        this.userRepository = userRepository;
    }


    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDto getByIdUser(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));

        try {
            String address = addressProxy.getAddressById(id);
            return DtoConverter.convert(user, address);
        } catch (Exception e) {
            // Handle exceptions that may occur during address retrieval
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error retrieving address for user id: " + id, e);
        }
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> userList = userRepository.findAll();

        // Assuming DtoConverter.convert(User, String) converts a User to UserDto
        List<UserDto> userDtoList = userList.stream()
                .map(user -> DtoConverter.convert(user, addressProxy.getAddressById(user.getId())))
                .collect(Collectors.toList());

        return userDtoList;
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
