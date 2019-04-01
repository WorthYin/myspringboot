package com.worth.springdemo.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinwushuo
 * @date 2019/1/25 17:59
 */
@Configuration
public class RabbitTopicConfig {
    public static final String TOPIC_QUEUE1 = "topic.queue1";
    public static final String TOPIC_QUEUE2 = "topic.queue2";
    public static final String TOPIC_EXCHANGE = "topic.exchange";

    @Bean
    public Queue topicQueue1() {
        return new Queue(TOPIC_QUEUE1);
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue(TOPIC_QUEUE2);
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("topic.message");
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("topic.#");
    }


    @Autowired
    @Bean
    public SimpleRabbitListenerContainerFactory rabbitListenerContainerFactory(CachingConnectionFactory cachingConnectionFactory) {

        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();

        factory.setConnectionFactory(cachingConnectionFactory);

//        factory.setMessageConverter(messageConverter);

        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);

        factory.setConcurrentConsumers(3);

        factory.setMaxConcurrentConsumers(5);

        factory.setPrefetchCount(250);

        factory.setChannelTransacted(false);

        factory.setTxSize(1);

        factory.setDefaultRequeueRejected(true);

//        factory.setErrorHandler(errorHandler);

        return factory;

    }


}
