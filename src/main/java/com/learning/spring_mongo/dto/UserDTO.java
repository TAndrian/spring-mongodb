package com.learning.spring_mongo.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;

import java.util.UUID;

public record UserDTO(
        UUID id,
        @NotEmpty(message = "Full name must be provided.")
        String fullName,
        @NotEmpty(message = "Age must be provided.")
        @Min(value = 18, message = "User cannot be underage.")
        @Max(value = 100)
        Integer age,
        @NotEmpty(message = "Gender must be provided.")
        String gender) {
}
