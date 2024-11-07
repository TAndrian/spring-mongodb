package com.learning.spring_mongo.document;

import com.learning.spring_mongo.util.TemporalBaseUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Document(collection = "users")
@CompoundIndex(name = "uniqueFullName", def = "{'fullName' : 1}", unique = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserDocument extends TemporalBaseUtil {
    @Id
    private String id = UUID.randomUUID().toString();
    private String fullName;
    private Integer age;
    private String gender;
}
