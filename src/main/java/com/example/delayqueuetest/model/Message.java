package com.example.delayqueuetest.model;

import lombok.Data;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

@Data
public class Message implements Delayed {
    private int id;
    // 消息内容
    private String body;
    // 延迟时长，这个是必须的属性因为要按照这个判断延时时长。
    private long excuteTime;

    public Message(int id, String body, long excuteTime) {
        this.id = id;
        this.body = body;
        this.excuteTime = TimeUnit.NANOSECONDS.convert(excuteTime, TimeUnit.MILLISECONDS) + System.nanoTime();
    }
    // 延迟任务是否到时就是按照这个方法判断如果返回的是负数则说明到期否则还没到期
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
    }
    //时间设定小的 优先被消费
    @Override
    public int compareTo(Delayed delayed) {
        Message o = (Message)delayed;
        return this.excuteTime -o.getExcuteTime() > 0 ? 1 : -1;
    }
}
