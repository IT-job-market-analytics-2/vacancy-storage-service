package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancy;
import com.dragunov.vacancystorageservice.model.VacancyEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;

import java.text.ParseException;


@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitListenerService {

    private final ConvertService convertService;

    private final MongoDbService mongoDbService;

    private final RabbitProducerService rabbitProducerService;

    @RabbitListener(queues = "${rabbitmq.imported-vacancies}")
    public void processImportedVacancy(String message) {
        Vacancy vacancyDto = convertService.convertMessageToDto(message);
        VacancyEntity vacancyEntity = convertService.convertDtoToEntity(vacancyDto);
        try {
            mongoDbService.addEntity(vacancyEntity);
            log.info("New vacancy send to new-vacancies-queue");
            rabbitProducerService.publishNewVacancy(vacancyDto);
        } catch (DuplicateKeyException e) {
            log.warn("Saving fail - duplicate, check query...");
            VacancyEntity vacancyPresent = mongoDbService.getEntityById(vacancyDto.getUuid()).get();
            mongoDbService.addQueryToVacancy(vacancyDto.getQuery(), vacancyPresent);
        } catch (ParseException c) {
            log.error("Error vacancy published data parsing");
        } catch (NullPointerException b) {
            log.error("Entity is null");
        }
    }
}
