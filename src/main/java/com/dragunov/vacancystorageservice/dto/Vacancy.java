package com.dragunov.vacancystorageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancy {

    @JsonProperty("id")
    private String uuid;

    @JsonProperty("name")
    private String name;

    @JsonProperty("area")
    private Area area;

    @JsonProperty("salary")
    private Salary salary;

    @JsonProperty("type")
    private Type type;

    @JsonProperty("responseUrl")
    private Object responseUrl;

    @JsonProperty("publishedAt")
    private String publishedAt;

    @JsonProperty("createdAt")
    private String createdAt;

    @JsonProperty("archived")
    private Boolean archived;

    @JsonProperty("alternateUrl")
    private String alternateUrl;

    @JsonProperty("employer")
    private Employer employer;

    @JsonProperty("snippet")
    private Snippet snippet;

    @JsonProperty("experience")
    private Experience experience;

    @JsonProperty("employment")
    private Employment employment;

    @JsonProperty("query")
    private String query;
}
