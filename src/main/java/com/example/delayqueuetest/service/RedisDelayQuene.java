package com.example.delayqueuetest.service;

import com.example.delayqueuetest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisDelayQuene {



    @Autowired
    RedisService redisService;
    public void put(){
    }
}
