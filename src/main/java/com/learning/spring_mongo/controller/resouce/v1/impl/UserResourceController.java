package com.learning.spring_mongo.controller.resouce.v1.impl;

import com.learning.spring_mongo.controller.resouce.v1.UserOperations;
import com.learning.spring_mongo.dto.UserDTO;
import com.learning.spring_mongo.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
public class UserResourceController implements UserOperations {

    private UserService userService;

    @Override
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @Override
    public UserDTO getUserById(UUID userId) {
        return userService.getUserById(userId);
    }

    @Override
    public UserDTO createUser(UserDTO userToCreate) {
        return userService.createUser(userToCreate);
    }

    @Override
    public UserDTO updateUser(UUID userId, UserDTO update) {
        return userService.updateUser(userId, update);
    }

    @Override
    public void deleteUser(UUID userId) {
        userService.deleteUser(userId);
    }
}
