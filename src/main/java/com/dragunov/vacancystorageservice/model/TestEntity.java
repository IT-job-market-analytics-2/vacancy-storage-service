package com.dragunov.vacancystorageservice.model;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
@Data
@Document(collection = "entities")
public class TestEntity {

    @Indexed(name = "main_index", unique = true)
    private String text;

    private Integer number;

    @Indexed(name = "ttl_index", expireAfterSeconds = 60)
    private Date createdAt;

}
