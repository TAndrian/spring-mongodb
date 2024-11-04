package com.learning.spring_mongo.repository;

import com.learning.spring_mongo.document.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.UUID;

@NoRepositoryBean
public interface UserRepository extends MongoRepository<UserDocument, UUID> {
    UserDocument findByFullName(String fullName);
}
