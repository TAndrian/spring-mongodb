package com.learning.spring_mongo.service.impl;

import com.learning.spring_mongo.document.UserDocument;
import com.learning.spring_mongo.dto.UserDTO;
import com.learning.spring_mongo.exception.ConflictException;
import com.learning.spring_mongo.exception.NotFoundException;
import com.learning.spring_mongo.exception.enums.v1.UserExceptionEnums;
import com.learning.spring_mongo.mapper.UserMapper;
import com.learning.spring_mongo.repository.UserRepository;
import com.learning.spring_mongo.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    public static final String USER_NOT_FOUND_LOG = "User not found with id: {}";
    private UserRepository userRepository;
    private UserMapper userMapper;

    @Override
    public List<UserDTO> getUsers() {
        return userMapper.toDTOs(userRepository.findAll());
    }

    @Override
    public UserDTO getUserById(String userId) {
        return userMapper.toDTO(getUserDocumentById(userId));
    }

    @Override
    public UserDTO createUser(UserDTO userToCreate) {
        checkExistingUserByFullName(userToCreate.fullName());
        UserDocument userDocumentToCreate = userMapper.fromDTO(userToCreate);
        return userMapper.toDTO(userRepository.save(userDocumentToCreate));
    }

    /**
     * Check user's existence by its full name and throw conflict error if user already exists.
     *
     * @param fullName user's full name.
     */
    private void checkExistingUserByFullName(String fullName) {
        userRepository.findTopByFullName(fullName).ifPresent(user -> {
            log.info("User already exists with full name: {}", fullName);
            throw new ConflictException(
                    UserExceptionEnums.USER_ALREADY_EXISTS.getValue(),
                    UserExceptionEnums.USER_EXCEPTION_CODE.getValue()
            );
        });
    }

    @Override
    public UserDTO updateUser(String userId, UserDTO update) {
        UserDocument targetUserDocument = getUserDocumentById(userId);
        userMapper.updateUserDocumentFromDTO(update, targetUserDocument);
        return userMapper.toDTO(userRepository.save(targetUserDocument));
    }

    @Override
    public void deleteUser(String userId) {
        UserDocument targetUserDocument = getUserDocumentById(userId);
        userRepository.delete(targetUserDocument);
    }


    /**
     * Retrieve user by userId reference.
     *
     * @param userId reference.
     * @return user if it is present.
     */
    private UserDocument getUserDocumentById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> {
                    log.info(USER_NOT_FOUND_LOG, userId);
                    return new NotFoundException(
                            UserExceptionEnums.USER_NOT_FOUND.getValue(),
                            UserExceptionEnums.USER_EXCEPTION_CODE.getValue()
                    );
                }
        );
    }
}
