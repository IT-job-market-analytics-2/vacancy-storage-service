package com.dragunov.vacancystorageservice.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;


import java.util.Objects;

import static java.util.Collections.singletonList;


@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {
    private final Environment env;

    @Autowired
    public MongoConfig(Environment env) {
        this.env = env;
    }

    @Override
    public String getDatabaseName() {
        return env.getProperty("spring.data.mongodb.database");
    }

    @Override
    protected boolean autoIndexCreation() {
        return true;
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        builder
                .credential(MongoCredential.createCredential(Objects.requireNonNull(env.getProperty("spring.data.mongodb.username")),
                        Objects.requireNonNull(env.getProperty("spring.data.mongodb.database")),
                        Objects.requireNonNull(env.getProperty("spring.data.mongodb.password")).toCharArray()))
                .applyToClusterSettings(settings -> {
                    settings.hosts(singletonList(new ServerAddress(env.getProperty("spring.data.mongodb.host"),
                            env.getProperty("spring.data.mongodb.port", Integer.class))));
                });
    }
}
