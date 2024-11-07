package com.learning.spring_mongo.service;

import com.learning.spring_mongo.dto.UserDTO;

import java.util.List;
import java.util.UUID;

public interface UserService {
    /**
     * Retrieve all users.
     *
     * @return users.
     */
    List<UserDTO> getUsers();

    /**
     * Retrieve user referenced by userId.
     *
     * @param userId user's reference.
     * @return corresponding user by userId reference.
     */
    UserDTO getUserById(String userId);

    /**
     * Create user form userToCreate DTO data.
     *
     * @param userToCreate DTO data.
     * @return created user.
     */
    UserDTO createUser(UserDTO userToCreate);

    /**
     * Update targeted user referenced by userId with the update data.
     *
     * @param userId user's reference.
     * @param update data.
     * @return updated user.
     */
    UserDTO updateUser(String userId, UserDTO update);

    /**
     * Delete targeted user referenced by userId.
     *
     * @param userId reference.
     */
    void deleteUser(String userId);
}
