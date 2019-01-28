package com.example.delayqueuetest.api;

import com.example.delayqueuetest.mapper.DemoMapper;
import com.example.delayqueuetest.model.Demo;
import com.example.delayqueuetest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    private DemoMapper demoMapper;

    @Autowired
    private RedisService redisService;

    @RequestMapping("/lists")
    public List<Demo> getList(){
        redisService.set(UUID.randomUUID().toString(),demoMapper.getList(),20L);
        return demoMapper.getList();
    }

}
