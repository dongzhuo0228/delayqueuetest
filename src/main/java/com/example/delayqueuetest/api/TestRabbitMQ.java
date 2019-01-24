package com.example.delayqueuetest.api;

import com.example.delayqueuetest.manager.FirstSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;


@RestController
@RequestMapping("/api")
@Slf4j
public class TestRabbitMQ {

    @Autowired
    private FirstSender firstSender;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/demo")
    public void testRabbit(String msg) {
        log.info("发送消息时间"+ LocalDateTime.now().toString());
       /* rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGEDEALY, RabbitMqConfig.ROUTINGKEY1, msg, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay",10000);
                return message;
            }
        });*/
        firstSender.send(UUID.randomUUID().toString(),msg);
    }
}
