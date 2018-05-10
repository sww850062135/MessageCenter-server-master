package com.sww.message.rabbitmq;

import com.sww.message.entity.Email;
import com.sww.message.entity.EmailRabbit;
import com.sww.message.service.EmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    private EmailService emailService;

    @Test
    public void topicEmail() throws Exception{
        //EmailRabbit emailRabbit = new EmailRabbit((new Email(30,"850062135@qq.com", "rabbitmqTest", "TopicTest")));
        //emailService.sendEmailToEmailQueue(emailRabbit);
    }


}
