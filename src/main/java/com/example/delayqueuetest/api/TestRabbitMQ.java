package com.example.delayqueuetest.api;

import com.example.delayqueuetest.manager.FirstSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/api")
public class TestRabbitMQ {

    @Autowired
    private FirstSender firstSender;
    @RequestMapping("/demo")
    public void testRabbit() {
        firstSender.send(UUID.randomUUID().toString(),"11111111111111111111111111");
    }
}