package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancies;
import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;
import org.springframework.dao.DuplicateKeyException;


@Service
@Slf4j
@RequiredArgsConstructor
public class RabbitListenerService {

    private final ConvertService convertService;

    private final MongoDbService mongoDbService;

    private final RabbitProducerService rabbitProducerService;

    @RabbitListener(queues = "${rabbitmq.imported-vacancies}")
    public void processImportedVacancy(String message) {
        Vacancies vacanciesDto = convertService.convertMessageToDto(message);
        VacanciesEntity vacanciesEntity = convertService.convertDtoToEntity(vacanciesDto);
        try {
            mongoDbService.addEntity(vacanciesEntity);
            log.info("New vacancy send to new-vacancies-queue");
            rabbitProducerService.publishNewVacancy(vacanciesDto);
        } catch (DuplicateKeyException e) {
            log.error("Saving fail - duplicate");
        } catch (NullPointerException b) {
            log.error("Entity is null");
        }
    }
}
