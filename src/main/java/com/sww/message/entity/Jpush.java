package com.sww.message.entity;




import java.sql.Timestamp;


public class Jpush {
    private int push_id;            //推送id
    private String platform;        //平台
    private String audience;        // 目标人群
    private String notification;    //通知内容
    private String message;         //message_content
    private long msg_id;          //message_id
    private int sendno;          //推送编码
    private Timestamp pushtime;     //推送时间


    public int getPush_id() {
        return push_id;
    }

    public void setPush_id(int push_id) {
        this.push_id = push_id;
    }


    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String content) {
        this.message = content;
    }

    public Timestamp getPushtime() {
        return pushtime;
    }

    public void setPushtime(Timestamp pushtime) {
        this.pushtime = pushtime;
    }

    public long getMsg_id() {
        return msg_id;
    }

    public void setMsg_id(long msg_id) {
        this.msg_id = msg_id;
    }

    public int getSendno() {
        return sendno;
    }

    public void setSendno(int sendno) {
        this.sendno = sendno;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getAudience() {
        return audience;
    }

    public void setAudience(String audience) {
        this.audience = audience;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer =new StringBuffer();
        stringBuffer.append("jpush{push_id:").append(this.push_id).append(",");
        stringBuffer.append("platform:").append(this.platform).append(",");
        stringBuffer.append("audience:").append(this.audience).append(",");
        stringBuffer.append("notification:").append(this.notification).append(",");
        stringBuffer.append("message:").append(this.message).append(",");
        stringBuffer.append("msg_id:").append(this.msg_id).append(",");
        stringBuffer.append("sendno:").append(this.sendno).append(",");
        stringBuffer.append("pushtime:").append(this.pushtime).append("}");
        return stringBuffer.toString();
    }
}
