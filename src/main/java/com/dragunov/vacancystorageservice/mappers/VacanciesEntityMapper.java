package com.dragunov.vacancystorageservice.mappers;

import com.dragunov.vacancystorageservice.dto.Vacancies;
import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {VacancyEntityMapper.class})
public interface VacanciesEntityMapper {
    VacanciesEntity toEntity(Vacancies vacanciesDto);
}