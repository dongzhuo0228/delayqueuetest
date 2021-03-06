package com.example.delayqueuetest.listener;

import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Key过期会触发这个操作  做自己的业务逻辑
 */
@Component
public class TopicMessageListener extends KeyExpirationEventMessageListener{

    public TopicMessageListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }
    /**
     * 针对redis数据失效事件，进行数据处理
     * @param message
     * @param pattern
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {
        // 用户做自己的业务处理即可,注意message.toString()可以获取失效的key
        String expiredKey = message.toString();
        System.err.println(LocalDateTime.now()+"过期的key    "+expiredKey);
        if(expiredKey.startsWith("Order:")){
            //如果是Order:开头的key，进行处理
            //取消订单
        }
    }

}
