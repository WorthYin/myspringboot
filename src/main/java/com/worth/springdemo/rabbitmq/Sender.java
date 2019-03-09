package com.worth.springdemo.rabbitmq;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class Sender {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Async
    public Future<String> sendAsync(String message) {
        String result = (String) amqpTemplate.convertSendAndReceive(RabbitConfig.UPGRADE_QUEUE, message);
        return new AsyncResult<String>(result);
    }
}
