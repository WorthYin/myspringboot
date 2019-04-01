package com.worth.springdemo.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Observable;
import java.util.Observer;

/**
 * @author yinwushuo
 * @date 2019/1/30 11:05
 */
@Service
@Slf4j
public class TopicObserver1 implements Observer{
    @Autowired
    TopicReceiverObservable topicReceiverObservable;

    @Autowired
    TopicReceiverObservable2 topicReceiverObservable2;

    @PostConstruct
    private void init(){
        topicReceiverObservable.addObserver(this);
        topicReceiverObservable2.addObserver(this);
    }


    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof TopicReceiverObservable){
            log.info("获得topic.message主题的信息：" + arg.toString());
        }
        if (o instanceof TopicReceiverObservable2){
            log.info("获得topic.#主题的信息：" + arg.toString());
        }
    }
}
