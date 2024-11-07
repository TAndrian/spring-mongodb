package com.learning.spring_mongo.controller.resouce.v1;

import com.learning.spring_mongo.dto.UserDTO;
import com.learning.spring_mongo.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.learning.spring_mongo.controller.Paths.BASE_URL;
import static com.learning.spring_mongo.controller.Paths.PATH_USER_ID;
import static com.learning.spring_mongo.controller.Paths.USER;
import static com.learning.spring_mongo.controller.Paths.USERS;

@RestController
@RequestMapping(
        path = BASE_URL,
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
)
@Validated
@AllArgsConstructor
public class UserResourceController {

    private UserService userService;

    @GetMapping(USERS)
    @ResponseStatus(HttpStatus.OK)
    public List<UserDTO> getUsers() {
        return userService.getUsers();
    }

    @GetMapping(PATH_USER_ID)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO getUserById(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping(USER)
    @ResponseStatus(HttpStatus.CREATED)
    public UserDTO createUser(@Valid @RequestBody UserDTO userToCreate) {
        return userService.createUser(userToCreate);
    }

    @PatchMapping(PATH_USER_ID)
    @ResponseStatus(HttpStatus.OK)
    public UserDTO updateUser(@PathVariable String userId, @RequestBody UserDTO update) {
        return userService.updateUser(userId, update);
    }

    @DeleteMapping(PATH_USER_ID)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
