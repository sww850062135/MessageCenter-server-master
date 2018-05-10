package com.sww.message.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sww.message.entity.Email;
import com.rabbitmq.client.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

//@Component("mailMessageListenerAdapter")
public class MailMessageListenerAdapter extends MessageListenerAdapter{
    private static Logger logger = LoggerFactory.getLogger(MessageListenerAdapter.class);
    @Resource
    private   JavaMailSender mailSender;

    @Value("${mail.username}")
    private String mailUsername;

    @Override
    public void onMessage(Message message, Channel channel) throws Exception{
        /**
         * 1. 从 RabbitMQ 的消息队列中解析消息体。
         * 2. 根据消息体的内容，发送邮件给目标的邮箱。
         * 3. 手动应答 ACK，让消息队列删除该消息。
         */
        try {
            //解析RabbitMQ消息体
            String messageBody = new String(message.getBody());
            Email email = JSONObject.toJavaObject(JSON.parseObject(messageBody), Email.class);
            //发送邮件
            String to =  email.getEmail_to();
            String subject = email.getSubject();
            String text = email.getText();
            sendHtmlMail(to, subject, text);
            logger.info("发送成功!");
            // 手动ACK
            channel.basicAck(message.getMessageProperties().getDeliveryTag(), false);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 发送邮件
     * @param to
     * @param subject
     * @param text
     */
    private  void sendHtmlMail(String to, String subject, String text) throws Exception{
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setFrom(mailUsername);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setSubject(subject);
        mimeMessageHelper.setText(text, true);

        //发送邮件
        mailSender.send(mimeMessage);
    }
}
