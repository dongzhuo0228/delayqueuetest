package com.example.delayqueuetest;

import com.alibaba.fastjson.JSON;
import com.example.delayqueuetest.jdkquene.Consumer;
import com.example.delayqueuetest.model.Message;
import com.example.delayqueuetest.service.RedisService;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import redis.clients.jedis.JedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@MapperScan("com.example.delayqueuetest.mapper")
@SpringBootApplication
@Slf4j
public class DelayqueuetestApplication implements CommandLineRunner {
    // 创建延时队列
    DelayQueue<Message> queue = new DelayQueue<Message>();
    @Autowired
    RedisService redisService;
    @Autowired
    JedisPool jedisPool;
    public static void main(String[] args) {
        SpringApplication.run(DelayqueuetestApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {

        List d = new ArrayList();
        d.add("1111");

        jedisPool.getResource().set("dz22222222222222","dddddddd");
//        redisService.set("dz1",d,10L);
        // 添加延时消息,m1 延时3s
        Message m1 = new Message(1, "world", 3000);
        // 添加延时消息,m3 延时15分钟
        Message m2 = new Message(3, "hello2", 10000*6*15);
        // 添加延时消息,m2 延时10s
        Message m3= new Message(2, "hello3", 20000);
        //将延时消息放到延时队列中
        queue.offer(m2);
        queue.offer(m3);
        queue.offer(m1);
        // 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
        ExecutorService exec = Executors.newFixedThreadPool(10);
//        exec.execute(new Consumer(queue));





        exec.execute(new Runnable() {
            @Override
            public void run() {
                while (true){
//                    List<String> dz = jedisPool.getResource().blpop(500, "dz22222222222222");
//                    log.info("redis阻塞队列的使用={}", JSON.toJSONString(dz));
                }

            }
        });

    }
}

