package com.worth.springdemo.rabbitmq.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinwushuo
 * @date 2019/1/25 16:24
 */
@Configuration
public class RabbitDirectConfig {
    public static final String DIRECT_QUEUE = "direct_queue";

    @Bean
    public Queue directQueue() {
        // 第一个参数是队列名字，第二个参数是指是否持久化
        return new Queue(DIRECT_QUEUE, true);
    }

}
