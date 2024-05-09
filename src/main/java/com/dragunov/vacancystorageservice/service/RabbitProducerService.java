package com.dragunov.vacancystorageservice.service;

import com.dragunov.vacancystorageservice.dto.Vacancy;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitProducerService {

    @Value("${rabbitmq.report-new-vacancies}")
    private String producer;

    private final RabbitTemplate rabbitTemplate;

    public void publishNewVacancy(Vacancy vacancy){
        rabbitTemplate.convertAndSend(producer, vacancy);
    }
}
