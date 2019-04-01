package com.worth.springdemo.rabbitmq;

import com.worth.springdemo.rabbitmq.config.RabbitTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinwushuo
 * @date 2019/1/25 18:22
 */
@Component
@Slf4j
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendTopic(String routeKey, Object message){
        log.info("[senderTopic已发送消息]" + "routeKey:" + routeKey+ "message:" + message.toString());
        this.amqpTemplate.convertAndSend(RabbitTopicConfig.TOPIC_EXCHANGE, routeKey, message);
    }
}
