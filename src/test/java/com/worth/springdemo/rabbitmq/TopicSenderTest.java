package com.worth.springdemo.rabbitmq;

import com.worth.springdemo.SpringdemoApplication;
import com.worth.springdemo.gateway.model.Gateway;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringdemoApplication.class)
public class TopicSenderTest {

    @Autowired
    TopicSender topicSender;

    @Test
    public void testSender() throws InterruptedException {
        int i = 0;
        while (i < 3){
            topicSender.sendTopic("topic.message", "信息key:topic.message");
            topicSender.sendTopic("topic.mm", "信息key:topic.mm");
            i++;
        }
        Thread.sleep(3000);

    }
}