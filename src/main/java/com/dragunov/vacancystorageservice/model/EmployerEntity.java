package com.dragunov.vacancystorageservice.model;

import lombok.Data;

@Data
public class EmployerEntity {
    private String id;

    private String name;

    private String url;

    private String alternateUrl;

    private LogoUrlsEntity logoUrlsEntity;

    private String vacanciesUrl;

    private Boolean accreditedItEmployer;

    private Boolean trusted;
}