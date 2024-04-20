package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancies;
import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;


@Component
public class RabbitListenerService {
    private final MongoTemplate mongoTemplate;
    private final ConvertService convertService;
    private final MongoDbService mongoDbService;

    @Value("${spring.data.mongodb.ttl_index}")
    private int indexTtl;

    @Autowired
    public RabbitListenerService(MongoTemplate mongoTemplate, ConvertService convertService, MongoDbService mongoDbService) {
        this.convertService = convertService;
        this.mongoTemplate = mongoTemplate;
        this.mongoDbService = mongoDbService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.imported-vacancies}")
    public void processImportedVacancy(byte[] message) {
        mongoTemplate.indexOps(VacanciesEntity.class).ensureIndex(new Index().expire(indexTtl, TimeUnit.DAYS).on("createdAt", Sort.Direction.ASC));
        String messageString = new String(message);
        Vacancies vacanciesDto = convertService.convertMessageToDto(messageString);
        VacanciesEntity vacanciesEntity = convertService.convertDtoToEntity(vacanciesDto);
        mongoDbService.addEntity(vacanciesEntity);
    }
}
