package com.worth.springdemo.sync.mysql;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author yinwwushuo
 * @date 2019/4/1 18:22
 */
@Service
@Slf4j
public class SyncMysqlClient {
    @Autowired
    BinaryLogClient binaryLogClient;

    @PostConstruct
    private void init(){
        binaryLogClient.registerEventListener(new BinaryLogClient.EventListener() {
            @Override
            public void onEvent(Event event) {
/*
                log.info(event.toString());
*/
            }
        });
    }

    @Async
    public void syncMysqlUpdate(){
        try {
            binaryLogClient.connect(5);
        } catch (TimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
