package com.worth.springdemo.rabbitmq;

import com.worth.springdemo.gateway.model.Gateway;
import com.worth.springdemo.rabbitmq.config.RabbitTopicConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Observable;

/**
 * @author yinwushuo
 * @date 2019/1/25 18:15
 */
@Component
@Slf4j
public class TopicReceiverObservable extends Observable {


   /* @RabbitHandler
    public void receiveTopic1(Gateway gateway) {
        log.info("[receiverTopic1监听到信息]" + gateway.toString());
        super.setChanged();
        notifyObservers(gateway);
    }*/

   /*//queues是指要监听的队列的名字
   @RabbitListener(queues = RabbitTopicConfig.TOPIC_QUEUE1)
    public void receiveObjectTopic(Object message) {
        log.info("[receiveObjectTopic监听到信息]" + message.toString());
        super.setChanged();
        notifyObservers(message);
    }*/

    @RabbitListener(queues = RabbitTopicConfig.TOPIC_QUEUE1)
    public void receiveStringTopic(String message) {
        log.info("receiveStringTopic监听到信息]" + message.toString());
        super.setChanged();
        notifyObservers(message);
    }

}
