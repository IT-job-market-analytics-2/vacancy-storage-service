package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancies;
import com.dragunov.vacancystorageservice.mappers.VacanciesEntityMapper;
import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class ConvertService {

    private final VacanciesEntityMapper vacanciesEntityMapper;
    private final ObjectMapper objectMapper;

    @Autowired
    public ConvertService(VacanciesEntityMapper vacanciesEntityMapper, ObjectMapper objectMapper) {
        this.vacanciesEntityMapper = vacanciesEntityMapper;
        this.objectMapper = objectMapper;
    }

    public Vacancies convertMessageToDto(String message) {
        try {
            log.info("Start convert message to DTO");
            objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
            return objectMapper.readValue(message, Vacancies.class);
        } catch (JsonProcessingException e) {
            log.error("Fail convert message to DTO, message - {}", message);
            return new Vacancies();
        }
    }

    public VacanciesEntity convertDtoToEntity(Vacancies vacanciesDto) {
        log.info("Start convert DTO to Entity");
        return vacanciesEntityMapper.toEntity(vacanciesDto);
    }
}
