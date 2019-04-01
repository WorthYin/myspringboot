package com.worth.springdemo.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    public static final String UPGRADE_QUEUE = "upgrade";

    @Bean
    public Queue upgradeQueue() {
        return new Queue(UPGRADE_QUEUE);
    }

}
