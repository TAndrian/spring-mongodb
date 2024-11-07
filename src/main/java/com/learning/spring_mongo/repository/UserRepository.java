package com.learning.spring_mongo.repository;

import com.learning.spring_mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDocument, String> {
    Optional<UserDocument> findTopByFullName(String fullName);
}
