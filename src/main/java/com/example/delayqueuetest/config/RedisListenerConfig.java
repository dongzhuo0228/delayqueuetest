package com.example.delayqueuetest.config;

import com.example.delayqueuetest.listener.TopicMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * 配置监听频道
 */
@Configuration
public class RedisListenerConfig {
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory) {
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        //
        /**  二选1 配置方式
         * redis.config   加入notify-keyspace-events Ex
         *  container.addMessageListener(new TopicMessageListener(container), new PatternTopic("__keyevent@0__:expired"));
         */
//        container.addMessageListener(new TopicMessageListener(container), new PatternTopic("__keyevent@0__:expired"));
        return container;
    }
}
