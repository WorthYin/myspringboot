package com.worth.springdemo.sync.mysql;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yinwushuo
 * @date 2019/4/1 18:37
 */
@Configuration
public class MysqlBinlogConfig {
    @Bean
    public BinaryLogClient binaryLogClient(){
        BinaryLogClient binaryLogClient = new BinaryLogClient("rm-2zegz2xfj3q6242cj0o.mysql.rds.aliyuncs.com", 3306,
                "cotx", "20170703Cotx");
        binaryLogClient.setEventDeserializer(eventDeserializer());
        return binaryLogClient;
    }

    @Bean
    public EventDeserializer eventDeserializer(){
        EventDeserializer eventDeserializer = new EventDeserializer();
        eventDeserializer.setCompatibilityMode(
                EventDeserializer.CompatibilityMode.DATE_AND_TIME_AS_LONG,
                EventDeserializer.CompatibilityMode.CHAR_AND_BINARY_AS_BYTE_ARRAY
        );
        return eventDeserializer;
    }
}
