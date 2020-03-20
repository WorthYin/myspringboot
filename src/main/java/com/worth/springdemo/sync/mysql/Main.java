package com.worth.springdemo.sync.mysql;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import lombok.extern.slf4j.Slf4j;
import java.io.IOException;
import com.github.shyiko.mysql.binlog.event.EventType;
/**
 * @author Administrator
 * @date 2019/4/1 18:56
 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        BinaryLogClient binaryLogClient = new BinaryLogClient(
                "rm-2zegz2xfj3q6242cj0o.mysql.rds.aliyuncs.com", 3306,
                "floodlight-dev",
                "cotx", "20170703Cotx");
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(
                EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG
        );
        binaryLogClient.setEventDeserializer(eventDeserializer);
        binaryLogClient.registerEventListener(new BinaryLogClient.EventListener() {
            @Override
            public void onEvent(Event event) {
                EventType eventType = event.getHeader().getEventType();
                if (EventType.isRowMutation(eventType) || EventType.TABLE_MAP.equals(eventType)){
                    log.info(event.getData().toString());
                }
            }
        });
        try {
            binaryLogClient.connect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
