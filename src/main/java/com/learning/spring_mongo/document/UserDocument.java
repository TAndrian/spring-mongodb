package com.learning.spring_mongo.document;

import com.learning.spring_mongo.util.TemporalBaseUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "users")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDocument extends TemporalBaseUtil {
    @Id
    private UUID id;
    private String fullName;
    private Integer age;
    private String gender;
}
