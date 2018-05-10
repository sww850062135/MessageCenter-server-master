package com.sww.message.config.rabbitMQ;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {
    private final static String queueEmail = "topic.email";
    private final static String queueJPush = "topic.jpush";


    /**
     * 消息队列
     * @return
     */
    @Bean
    public Queue queueEmail(){
        return new Queue(TopicRabbitConfig.queueEmail);
    }

    @Bean
    public Queue queueJPush(){
        return new Queue(TopicRabbitConfig.queueJPush);
    }

    /**
     * 交换机
      * @return
     */
    @Bean
    TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    /**
     * 绑定队列到路由上，路由模式，需匹配完整的routingKey才能接收
     * @param queueEmail        队列名
     * @param topicExchange     交换机
     * @return
     */
    @Bean
    Binding bindingExchangeEmail(Queue queueEmail, TopicExchange topicExchange){
        return BindingBuilder.bind(queueEmail).to(topicExchange).with("topic.email");
    }

    /**
     * topic模式,前缀匹配到topic.即可接收;   符号#匹配一个或多个词，符号*匹配不多不少一个词
      * @param queueJPush       队列名
     * @param topicExchange     交换机
     * @return
     */
    @Bean
    Binding bindingExchangeJPush(Queue queueJPush, TopicExchange topicExchange){
        return BindingBuilder.bind(queueJPush).to(topicExchange).with("topic.jpush");
    }
}
