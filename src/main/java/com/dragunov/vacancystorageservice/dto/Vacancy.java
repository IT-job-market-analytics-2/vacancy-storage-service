package com.dragunov.vacancystorageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Vacancy {

    @JsonProperty("id")
    private String id;

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

    @JsonProperty("published_at")
    private String publishedAt;

    @JsonProperty("created_at")
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
}
