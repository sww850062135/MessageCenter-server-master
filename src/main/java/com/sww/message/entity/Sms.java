package com.sww.message.entity;

import java.sql.Timestamp;

public class Sms {
    private int sms_id;             //主键
    private String mobile;          //手机号码
    private String templateid;      //短信模版编号
    private String temp;           //模版中的替换参数
    private String uid;             //用户透传id，随状态报告返回
    private String sms_content;     //短信内容
    private String sms_status;      //短信状态
    private String smsType;        //短信类型
    private Timestamp sendtime;     //发送时间

    public Sms(){

    }
    public int getSms_id() {
        return sms_id;
    }

    public void setSms_id(int sms_id) {
        this.sms_id = sms_id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSms_content() {
        return sms_content;
    }

    public void setSms_content(String sms_content) {
        this.sms_content = sms_content;
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getSms_status() {
        return sms_status;
    }

    public void setSms_status(String sms_status) {
        this.sms_status = sms_status;
    }

    public String getSmsType() {
        return smsType;
    }

    public void setSmsType(String smsType) {
        this.smsType = smsType;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Timestamp getSendtime() {
        return sendtime;
    }

    public void setSendtime(Timestamp sendtime) {
        this.sendtime = sendtime;
    }


}
