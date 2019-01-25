package com.example.delayqueuetest.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

public class MsgSendReturnCallBack implements  RabbitTemplate.ReturnCallback {
    @Override
    public void returnedMessage(Message message, int i, String s, String s1, String s2) {
        System.out.println("MsgSendReturnCallBack"+message.getBody());

    }
}
