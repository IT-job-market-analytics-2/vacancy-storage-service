package com.dragunov.vacancystorageservice.config;

import com.dragunov.vacancystorageservice.service.RabbitListenerService;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;


@Configuration
@EnableRabbit
public class RabbitConfig {

    private final Environment env;
    private static final String queueName = "imported-vacancies-queue";

    @Autowired
    public RabbitConfig(Environment env) {
        this.env = env;
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, true);
    }

    @Bean
    public ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(env.getProperty("spring.rabbitmq.host"));
        connectionFactory.setUsername(Objects.requireNonNull(env.getProperty("spring.rabbitmq.username")));
        connectionFactory.setPassword(Objects.requireNonNull(env.getProperty("spring.rabbitmq.password")));
        connectionFactory.setPort(env.getProperty("spring.rabbitmq.port", Integer.class));
        return connectionFactory;
    }

    @Bean
    public MessageListenerAdapter listenerAdapter(RabbitListenerService receiver) {
        return new MessageListenerAdapter(receiver, " processImportedVacancy");
    }
}
