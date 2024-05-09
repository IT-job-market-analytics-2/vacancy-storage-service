package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Employment;
import com.dragunov.vacancystorageservice.dto.Vacancy;
import com.dragunov.vacancystorageservice.model.EmploymentEntity;
import com.dragunov.vacancystorageservice.model.VacancyEntity;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-09T12:11:05+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class VacancyEntityMapperImpl implements VacancyEntityMapper {

    @Autowired
    private AreaEntityMapper areaEntityMapper;
    @Autowired
    private SalaryEntityMapper salaryEntityMapper;
    @Autowired
    private TypeEntityMapper typeEntityMapper;
    @Autowired
    private EmployerEntityMapper employerEntityMapper;
    @Autowired
    private SnippetEntityMapper snippetEntityMapper;
    @Autowired
    private ExperienceEntityMapper experienceEntityMapper;

    @Override
    public VacancyEntity toEntity(Vacancy vacancyDto) {
        if ( vacancyDto == null ) {
            return null;
        }

        VacancyEntity vacancyEntity = new VacancyEntity();

        vacancyEntity.setAreaEntity( areaEntityMapper.toEntity( vacancyDto.getArea() ) );
        vacancyEntity.setSalaryEntity( salaryEntityMapper.toEntity( vacancyDto.getSalary() ) );
        vacancyEntity.setTypeEntity( typeEntityMapper.toEntity( vacancyDto.getType() ) );
        vacancyEntity.setEmployerEntity( employerEntityMapper.toEntity( vacancyDto.getEmployer() ) );
        vacancyEntity.setSnippetEntity( snippetEntityMapper.toEntity( vacancyDto.getSnippet() ) );
        vacancyEntity.setExperienceEntity( experienceEntityMapper.toEntity( vacancyDto.getExperience() ) );
        vacancyEntity.setEmploymentEntity( employmentToEmploymentEntity( vacancyDto.getEmployment() ) );
        vacancyEntity.setUuid( vacancyDto.getUuid() );
        vacancyEntity.setName( vacancyDto.getName() );
        vacancyEntity.setResponseUrl( vacancyDto.getResponseUrl() );
        vacancyEntity.setPublishedAt( vacancyDto.getPublishedAt() );
        vacancyEntity.setCreatedAt( vacancyDto.getCreatedAt() );
        vacancyEntity.setArchived( vacancyDto.getArchived() );
        vacancyEntity.setAlternateUrl( vacancyDto.getAlternateUrl() );

        return vacancyEntity;
    }

    protected EmploymentEntity employmentToEmploymentEntity(Employment employment) {
        if ( employment == null ) {
            return null;
        }

        EmploymentEntity employmentEntity = new EmploymentEntity();

        employmentEntity.setId( employment.getId() );
        employmentEntity.setName( employment.getName() );

        return employmentEntity;
    }
}
