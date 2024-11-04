package com.learning.spring_mongo.util;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDate;

@Data
public class TemporalBaseUtil {
    @CreatedDate
    @Field(name = "created_at")
    private LocalDate createdAt;
    @LastModifiedDate
    @Field(name = "updated_at")
    private LocalDate updatedAt;
}
