package com.dragunov.vacancystorageservice.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class RabbitListenerService {

    @RabbitListener(queues = "${spring.rabbitmq.queue.imported-vacancies}")
    public void processImportedVacancy(byte[] message) {
        String messageString = new String(message);
        System.out.println("Received message from imported-vacancies-queue " + messageString);
    }
}
