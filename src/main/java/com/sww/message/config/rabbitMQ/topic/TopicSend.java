package com.sww.message.config.rabbitMQ.topic;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TopicSend {
    @Autowired
    private AmqpTemplate rabbitTemplate;

    /**
     * routingKey: topic.email
     */
    public void sendEmail(){
        String context = "Hi, I am email";
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.email", context);
    }

    /**
     * routingKey: topic.jpush
     */
    public void sendJPush(){
        String context = "Hi, I am JPush";
        System.out.println("Sender: " + context);
        this.rabbitTemplate.convertAndSend("topicExchange", "topic.jpush", context);
    }
}
