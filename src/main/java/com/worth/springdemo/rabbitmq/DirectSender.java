package com.worth.springdemo.rabbitmq;

import com.worth.springdemo.gateway.model.Gateway;
import com.worth.springdemo.rabbitmq.config.RabbitDirectConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yinwushuo
 * @date 2019/1/25 16:47
 */
@Component
@Slf4j
public class DirectSender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void sendDirectQueue(Object message) {
        log.info("[senderDirectQueue已发送消息]");
        // 第一个参数是指要发送到哪个队列，第二个参数是指要发送的内容
        this.amqpTemplate.convertAndSend(RabbitDirectConfig.DIRECT_QUEUE, message);
    }
}
