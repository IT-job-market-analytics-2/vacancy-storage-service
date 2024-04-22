package com.dragunov.vacancystorageservice.model;


import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "vacancies")
public class VacanciesEntity {

    @Indexed(name = "main_index", unique = true)
    private List<VacancyEntity> vacancies;

    private Integer found;

    private Integer pages;

    private Integer perPage;

    private Integer page;

    private Object clusters;

    private Object arguments;

    private String alternateUrl;

    private Date createdAt;
}