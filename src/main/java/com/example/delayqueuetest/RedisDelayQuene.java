package com.example.delayqueuetest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class RedisDelayQuene {



    @Autowired
    RedisService redisService;
    public void put(){
    }
}
