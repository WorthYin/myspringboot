package com.worth.springdemo.rabbitmq;

import com.worth.springdemo.gateway.model.Gateway;
import com.worth.springdemo.rabbitmq.config.RabbitDirectConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yinwushuo
 * @date 2019/1/25 16:30
 */
@Component
@Slf4j
public class DirectReceiver {

    //queues是指要监听的队列的名字
    @RabbitListener(queues = RabbitDirectConfig.DIRECT_QUEUE)
    public void receiverDirectQueue(Gateway gateway) {
        log.info("[receiverDirectQueue监听到信息]" + gateway.toString());
    }
}
