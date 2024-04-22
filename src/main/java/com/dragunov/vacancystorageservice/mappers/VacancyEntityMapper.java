package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Vacancy;
import com.dragunov.vacancystorageservice.model.VacancyEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {AreaEntityMapper.class, SalaryEntityMapper.class, TypeEntityMapper.class,
        EmployerEntityMapper.class, SnippetEntityMapper.class, ExperienceEntityMapper.class, EmploymentEntityMapper.class})
public interface VacancyEntityMapper {

    @Mapping(target = "areaEntity", source = "vacancyDto.area")
    @Mapping(target = "salaryEntity", source = "vacancyDto.salary")
    @Mapping(target = "typeEntity", source = "vacancyDto.type")
    @Mapping(target = "employerEntity", source = "vacancyDto.employer", qualifiedByName = "customMapping")
    @Mapping(target = "snippetEntity", source = "vacancyDto.snippet")
    @Mapping(target = "experienceEntity", source = "vacancyDto.experience")
    @Mapping(target = "employmentEntity", source = "vacancyDto.employment")
    VacancyEntity toEntity(Vacancy vacancyDto);
}