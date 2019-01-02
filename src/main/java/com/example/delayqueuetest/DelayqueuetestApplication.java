package com.example.delayqueuetest;

import com.example.delayqueuetest.jdkquene.Consumer;
import com.example.delayqueuetest.model.Message;
import com.example.delayqueuetest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class DelayqueuetestApplication implements CommandLineRunner {
    // 创建延时队列
    DelayQueue<Message> queue = new DelayQueue<Message>();
    @Autowired
    RedisService redisService;
    public static void main(String[] args) {
        SpringApplication.run(DelayqueuetestApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        redisService.set("order","111",10L);
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
        ExecutorService exec = Executors.newFixedThreadPool(1);
        exec.execute(new Consumer(queue));
        exec.shutdown();
    }
}

