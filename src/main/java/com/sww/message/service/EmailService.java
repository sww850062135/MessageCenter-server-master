package com.sww.message.service;

import com.sww.message.entity.Email;
import com.sww.message.entity.EmailRabbit;

import java.util.List;

public interface EmailService {
    Email getEmailById(Integer mail_id);                                    //根据ID查询邮件


    List<Email> getEmailListBySubject(String subject);                      //根据subject查询邮件记录


    List<Email> getEmailList(int pageNum, int pageSize) throws Exception;   //查询邮件列表


    List<Email> getEmailListByEmail_to(String email_to);                    //根据收件人email_to查询邮件记录


    int add(Email email);                                                   //增加一个推送记录


    int sendSimpleMail(Email email) throws Exception;                       //发送邮件推送


    int sendEmailToEmailQueue(EmailRabbit emailRabbit);                     //将发送邮件任务推到rabbitmq的消息队列中

}
