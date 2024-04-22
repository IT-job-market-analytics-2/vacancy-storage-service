package com.dragunov.vacancystorageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Snippet {
    @JsonProperty("requirement")
    private String requirement;
    @JsonProperty("responsibility")
    private String responsibility;
}