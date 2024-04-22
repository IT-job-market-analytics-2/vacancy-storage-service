package com.dragunov.vacancystorageservice.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Employer {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("url")
    private String url;

    @JsonProperty("alternateUrl")
    private String alternateUrl;

    @JsonProperty("logoUrls")
    private LogoUrls logoUrls;

    @JsonProperty("vacanciesUrl")
    private String vacanciesUrl;

    @JsonProperty("accreditedItEmployer")
    private Boolean accreditedItEmployer;

    @JsonProperty("trusted")
    private Boolean trusted;
}