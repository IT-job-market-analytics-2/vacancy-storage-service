package com.dragunov.vacancystorageservice.service;

import lombok.Getter;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
@Getter
public class RabbitListenerService {

    private final CountDownLatch latch = new CountDownLatch(1);

    private static final String queueName = "imported-vacancies-queue";

    @RabbitListener(queues = queueName)
    public void processImportedVacancy(byte[] message) {
        String messageString = new String(message);
        System.out.println("Received message from " + queueName + " " + messageString);
        latch.countDown();
    }
}
