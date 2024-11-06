package com.learning.spring_mongo.configs;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;

@Configuration
public class MongoDbConfig extends AbstractMongoClientConfiguration {

    Dotenv dotenv = Dotenv.load();
    private final String mongoUri=dotenv.get("MONGO_URI");

    @Override
    protected String getDatabaseName() {
        return "spring_mongodb";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder.applyConnectionString(new ConnectionString(mongoUri));
    }
}
