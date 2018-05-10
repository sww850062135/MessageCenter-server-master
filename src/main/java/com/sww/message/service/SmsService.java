package com.sww.message.service;

import com.sww.message.entity.Sms;
import com.sww.message.entity.Template;

import java.util.List;

public interface SmsService {


    //指定模版单发
    int SendSms(Sms sms);

    //指定模版群发
    int SendSmsBatch(Sms sms);

    //增加一条短信模版
    int AddSmsTemplate(Template template);

    //查询短信模版
    String GetSmsTemplate(Template template, String page_num, String page_size);

    //编辑短信模版
    String EditSmsTemplate(Template template);

    //删除短信模版
    String DeleterSmsTemplate(Template template);

    //增加一条sms记录
    int add(Sms sms);

    //查询sms记录列表
   List<Sms> getSmsList(int pageNum, int pageSize);

    //根据手机号mobile查询sms记录
    List<Sms> getSmsListByMobile(String mobile);
}
