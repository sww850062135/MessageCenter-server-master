package com.sww.message.config.rabbitMQ.topic;

import com.sww.message.entity.Email;
import com.sww.message.service.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "topic.email")
public class TopicEmailReceiver {
    @Autowired
    private EmailService emailService;
    @RabbitHandler
    public void sendEmail(Email email){
        System.out.println("Topic Email Receiver: " + email);
        try {
            emailService.sendSimpleMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
