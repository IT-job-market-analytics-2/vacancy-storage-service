package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Experience;
import com.dragunov.vacancystorageservice.model.ExperienceEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-10T17:59:12+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.9 (Oracle Corporation)"
)
@Component
public class ExperienceEntityMapperImpl implements ExperienceEntityMapper {

    @Override
    public ExperienceEntity toEntity(Experience experienceDto) {
        if ( experienceDto == null ) {
            return null;
        }

        ExperienceEntity experienceEntity = new ExperienceEntity();

        experienceEntity.setId( experienceDto.getId() );
        experienceEntity.setName( experienceDto.getName() );

        return experienceEntity;
    }
}
