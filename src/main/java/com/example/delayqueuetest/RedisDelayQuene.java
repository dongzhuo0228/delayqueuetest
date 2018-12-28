package com.example.delayqueuetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RedisDelayQuene {



    @Autowired
    RedisService redisService;
    public void put(){
    }
}
