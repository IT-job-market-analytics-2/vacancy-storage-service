package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Experience;
import com.dragunov.vacancystorageservice.model.ExperienceEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ExperienceEntityMapper {
    ExperienceEntity toEntity(Experience experienceDto);
}
