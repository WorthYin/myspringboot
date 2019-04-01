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
public class DirectSenderTest {
    @Autowired
    DirectSender directSender;

    @Test
    public void  testSender(){
        Gateway gateway = new Gateway();
        gateway.setName("test-gateway");
        gateway.setDescription("test direct queue  message");
        directSender.sendDirectQueue(gateway);
    }


}