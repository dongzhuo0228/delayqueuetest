package com.example.delayqueuetest.api;

import com.example.delayqueuetest.config.RabbitMqConfig;
import com.example.delayqueuetest.manager.FirstSender;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.Correlation;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class TestRabbitMQ {

    @Autowired
    private FirstSender firstSender;
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RequestMapping("/demo")
    public void testRabbit() {
        rabbitTemplate.convertAndSend(RabbitMqConfig.EXCHANGEDEALY, "first-queue", "11111111111", new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws AmqpException {
                message.getMessageProperties().setHeader("x-delay",3000);
                return message;
            }
        });
//        firstSender.send(UUID.randomUUID().toString(),"11111111111111111111111111");
    }
}
