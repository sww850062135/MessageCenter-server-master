package com.sww.message.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Email {

    //配置序列化时，不序列化
    @JSONField(serialize = false)
    private int mail_id;

    @JSONField(name = "email_to")
    private String email_to;

    @JSONField(name = "subject")
    private String subject;

    @JSONField(name = "text")
    private String text;

    //@JSONField(format= "yyyy-MM-dd HH:mm:ss" )  //定制日期格式
    private Timestamp sendtime;

    public Email(int mail_id,String email_to, String subject, String text) {
        this.mail_id = mail_id;
        this.email_to = email_to;
        this.subject = subject;
        this.text = text;
        this.sendtime = sendtime;
    }
    public Email(){

    }

    public int getMail_id() {
        return mail_id;
    }

    public void setMail_id(int mail_id) {
        this.mail_id = mail_id;
    }


    public void setEmail_to(String email_to) {
        this.email_to = email_to;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setText(String text) {
        this.text = text;
    }

    //@JsonFormat(pattern = "yyyy-MM-dd HH-mm-ss")  //定制日期格式 方法1：在set方法里加该注解  方法2：在application.yml配置文件加上
    //spring.jackson.date-format=yyyy-MM-dd HH:mm:ss
    public void setSendtime(Timestamp sendtime){

        this.sendtime=sendtime;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    //定制json数据格式
    @Override
    public String toString() {
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("Email{id:").append(this.mail_id).append(",");
        stringBuffer.append("email_to:").append(this.email_to).append(",");
        stringBuffer.append("subject:").append(this.subject).append(",");
        stringBuffer.append("text:").append(this.text).append(",");
        stringBuffer.append("sendtime:").append(this.sendtime).append("}");
        return stringBuffer.toString();
    }

    public String getEmail_to() {
        return email_to;
    }

    public String getSubject() {
        return subject;
    }

    public String getText() {
        return text;
    }
}
