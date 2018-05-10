package com.sww.message.service.impl;


import com.sww.message.config.EmailConfig;
import com.sww.message.entity.Email;
import com.sww.message.entity.EmailRabbit;
import com.sww.message.mapper.EmailMapper;
import com.sww.message.service.EmailService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    private static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Autowired
    private EmailMapper emailMapper;

    @Autowired
    private EmailConfig emailConfig;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private RabbitTemplate rabbitTemplate;
    /*@Resource(name = "rabbitTemplate")
    private RabbitTemplate rabbitTemplate;

    @Value("${mq.exchange}")
    private String exchange;

    @Value("${mq.routekey}")
    private String routekey;*/

    /*@Value("${spring.mail.username}")
    private String MailSender;*/


    /**
     * 发送邮件
     * @param email
     * @return
     * @throws Exception
     */
    @Override
    public int sendSimpleMail(Email email) throws Exception {
        logger.info("正在发送邮件....");
        logger.info("发件人:" +emailConfig.getEmail_from());
        logger.info("收件人:" + email.getEmail_to());
        logger.info("邮件主题:" + email.getSubject());
        logger.info("邮件内容:" + email.getText());

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(emailConfig.getEmail_from());
        mailMessage.setTo(email.getEmail_to());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getText());
        try {
            mailSender.send(mailMessage);
            logger.info("成功发送一封邮件");
            return 1;                               //邮件发送成功，返回1
        }catch (Exception e){
            logger.error(e.getMessage());
            return 0;
        }
    }


    @Override
    public Email getEmailById(Integer mail_id) {
        return emailMapper.getEmailById(mail_id);
    }


    @Override
    public List<Email> getEmailListBySubject(String subject ) {
        return emailMapper.getEmailListBySubject(subject);
    }


    @Override
    public List<Email> getEmailList(int pageNum, int pageSize) throws Exception {
        //使用分页插件
        PageHelper.startPage(pageNum, pageSize);
        return emailMapper.getEmailList();
    }


    @Override
    public List<Email> getEmailListByEmail_to(String email_to) {
        return emailMapper.getEmailListByEmail_to(email_to);
    }


    @Override
    public int add(Email email) {
        return emailMapper.add(email);
    }

    @Override
    public int sendEmailToEmailQueue(EmailRabbit emailRabbit) {
        System.out.println("EmailSender:"+ emailRabbit);
        //将对象email封装成Message对象后，发送给exchange
        this.rabbitTemplate.convertAndSend("TopicExchange", "topic.email", emailRabbit);
        return 1;
    }

}
