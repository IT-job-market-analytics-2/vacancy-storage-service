package com.dragunov.vacancystorageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LogoUrls {

    @JsonProperty("original")
    private String original;

    @JsonProperty("_90")
    private String _90;

    @JsonProperty("_240")
    private String _240;
}