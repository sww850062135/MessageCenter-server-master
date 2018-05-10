package com.sww.message.service.impl;

import com.sww.message.entity.Template;
import com.sww.message.mapper.TemplateMapper;
import com.sww.message.service.TemplateService;
import com.sww.message.util.SMS.client.AbsRestClient;
import com.sww.message.util.SMS.client.JsonReqClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TemplateServiceImpl implements TemplateService {


    private static final String TOKEN = "bfa3998ed6c4b79114fc198d7128e4f8";         //鉴权密钥
    private static final String APP_ID = "4c3210d1323b42e4a92fc4b1e9cff331";        //应用ID
    private static final String ACCOUNT_SID = "6a134d2969765f84d9e83741c856d53b";   //用户sid

    private static AbsRestClient InstantiationRestAPI(){
        return new JsonReqClient();
    }

    @Autowired
    private TemplateMapper templateMapper;


    @Override
    public void addSmsTemplate(Template template) {

    }
}
