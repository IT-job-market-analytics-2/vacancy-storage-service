package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancy;
import com.dragunov.vacancystorageservice.mappers.VacancyEntityMapper;
import com.dragunov.vacancystorageservice.model.VacancyEntity;
import com.dragunov.vacancystorageservice.utils.Validator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConvertService {

    private final VacancyEntityMapper vacancyEntityMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public ConvertService(VacancyEntityMapper vacancyEntityMapper, ObjectMapper objectMapper) {
        this.vacancyEntityMapper = vacancyEntityMapper;
        this.objectMapper = objectMapper;
    }

    public Vacancy convertMessageToDto(String message) {
        try {
            log.info("Start convert message to DTO");
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            return objectMapper.readValue(message, Vacancy.class);
        } catch (JsonProcessingException e) {
            log.error("Fail convert message to DTO, message - {}", message);
            return new Vacancy();
        }
    }

    public VacancyEntity convertDtoToEntity(Vacancy vacancyDto) {
        log.info("Start convert DTO to Entity, DTO - {}", vacancyDto);
        vacancyDto.setQuery(Validator.validateQuery(vacancyDto.getQuery()));
        return vacancyEntityMapper.toEntity(vacancyDto);
    }
}
