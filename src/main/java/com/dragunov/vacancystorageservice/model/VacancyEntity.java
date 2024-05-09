package com.dragunov.vacancystorageservice.model;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "vacancy")
@Slf4j
public class VacancyEntity {

    @Indexed(name = "main_index", unique = true)
    private String uuid;

    private String name;

    private AreaEntity areaEntity;

    private SalaryEntity salaryEntity;

    private TypeEntity typeEntity;

    private Object responseUrl;

    private String publishedAt;

    private String createdAt;

    private Boolean archived;

    private String alternateUrl;

    private EmployerEntity employerEntity;

    private SnippetEntity snippetEntity;

    private ExperienceEntity experienceEntity;

    private EmploymentEntity employmentEntity;

    private Date deleteAt;
}
