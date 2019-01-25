package com.example.delayqueuetest.manager;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 消息消费者
 */
@Component
@Slf4j
public class FirstConsumer {

    @RabbitListener(queues = {"first-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage(String message) throws Exception {
        // 处理消息
        log.info("FirstConsumer {} handleMessage :时间为         " +LocalDateTime.now().toString()+"消息体为"+message);
    }
    @RabbitListener(queues = {"second-queue"}, containerFactory = "rabbitListenerContainerFactory")
    public void handleMessage1(String message) throws Exception {
        // 处理消息
        System.out.println("FirstConsumer {} handleMessage1 :" + message);
    }
}