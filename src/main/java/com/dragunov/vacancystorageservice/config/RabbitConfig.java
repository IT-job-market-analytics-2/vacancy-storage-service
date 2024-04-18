package com.dragunov.vacancystorageservice.config;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;


@Configuration
@EnableRabbit
public class RabbitConfig {

    private final Environment env;

    @Value("${spring.rabbitmq.queue.imported-vacancies}")
    private String queueName;

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
}
