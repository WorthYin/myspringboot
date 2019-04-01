package com.worth.springdemo.rabbitmq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class senderTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    Sender sender;

    @Test
    public void senderMessage() throws ExecutionException, InterruptedException {
        String[] messages = {"hello", "你好", "okok"};
        List<Future<String>> results = new ArrayList<>();
        for (String m : messages) {
            Future<String> result = sender.sendAsync(m);
            results.add(result);
        }
        for (Future<String> result : results) {
            logger.info(result.get());
        }
    }
}