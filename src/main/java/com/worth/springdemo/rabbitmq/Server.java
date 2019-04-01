package com.worth.springdemo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Component
public class Server {
    Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    AmqpTemplate amqpTemplate;
    @RabbitListener(queues = RabbitConfig.UPGRADE_QUEUE)
    public void presses(String message, @Header(AmqpHeaders.REPLY_TO) String replyTo,
                          @Header(AmqpHeaders.CORRELATION_ID) String correlationId){
        logger.info("接受到消息{}，correlation id{}", message, correlationId);
        ListenableFuture<String> resultF = expensiveOperation(message);
        Correlation correlation = new CorrelationData(correlationId);
        resultF.addCallback(new ListenableFutureCallback<String>() {
            @Override
            public void onSuccess(String result) {
                amqpTemplate.convertAndSend(replyTo, (Object) result, new MessagePostProcessor() {
                    @Override
                    public Message postProcessMessage(Message message) {
                        //https://stackoverflow.com/questions/42382307/messageproperties-setcorrelationidstring-is-not-working
                        message.getMessageProperties().setCorrelationId(correlationId);
                        return message;
                    }
                });
            }

            @Override
            public void onFailure(Throwable ex) {

            };
        });

    }

    @Async
    public ListenableFuture<String> expensiveOperation(String message) {
        int millis = (int) (2 * 1000);
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
        String result = message + " executed by " + Thread.currentThread().getName() + " for " + millis + " ms";
        return new AsyncResult<String>(result);
    }
}
