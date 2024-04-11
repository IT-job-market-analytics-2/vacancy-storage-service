package com.dragunov.vacancystorageservice.model;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "entities")
public class TestEntity {

    private String text;

    private Integer number;


    private Date createdAt;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "number=" + number +
                ", text='" + text + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
