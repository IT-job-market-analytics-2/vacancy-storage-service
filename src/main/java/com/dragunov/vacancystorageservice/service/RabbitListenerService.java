package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancies;
import com.dragunov.vacancystorageservice.model.VacanciesEntity;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;




@Component
public class RabbitListenerService {
    private final ConvertService convertService;
    private final MongoDbService mongoDbService;


    @Autowired
    public RabbitListenerService(ConvertService convertService, MongoDbService mongoDbService) {
        this.convertService = convertService;
        this.mongoDbService = mongoDbService;
    }

    @RabbitListener(queues = "${spring.rabbitmq.queue.imported-vacancies}")
    public void processImportedVacancy(byte[] message) {
        String messageString = new String(message);
        Vacancies vacanciesDto = convertService.convertMessageToDto(messageString);
        VacanciesEntity vacanciesEntity = convertService.convertDtoToEntity(vacanciesDto);
        mongoDbService.addEntity(vacanciesEntity);
    }
}
