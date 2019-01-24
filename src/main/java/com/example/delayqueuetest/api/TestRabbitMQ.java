package com.example.delayqueuetest.api;

import com.example.delayqueuetest.config.RabbitMqConfig;
import com.example.delayqueuetest.manager.FirstSender;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;


@RestController
@RequestMapping("/api")
@Slf4j
public class TestRabbitMQ {

    @Autowired
    private FirstSender firstSender;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/demo")
    public void testRabbit() {
        log.info("发送消息时间"+ LocalDateTime.now().toString());
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGEDEALY, RabbitMqConfig.ROUTINGKEY1, "11111111111", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay",10000);
                return message;
            }
        });
//        firstSender.send(UUID.randomUUID().toString(),"11111111111111111111111111");
    }
}
