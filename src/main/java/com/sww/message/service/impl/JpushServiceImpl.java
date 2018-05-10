package com.sww.message.service.impl;


import cn.jiguang.common.resp.APIConnectionException;
import cn.jiguang.common.resp.APIRequestException;
import cn.jpush.api.JPushClient;
import cn.jpush.api.push.PushResult;
import cn.jpush.api.push.model.Message;
import cn.jpush.api.push.model.Platform;
import cn.jpush.api.push.model.PushPayload;
import cn.jpush.api.push.model.audience.Audience;
import cn.jpush.api.push.model.notification.Notification;
import com.sww.message.entity.Jpush;
import com.sww.message.mapper.JpushMapper;
import com.sww.message.service.JpushService;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpushServiceImpl implements JpushService {
    private static Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    private static final String MASTER_SECRET = "c4867f6af42c4e80011cf268";     //master_secret
    private static final String APP_KEY = "8ffe2005644a3a00f0f4d08a";           //appKey

    private static JPushClient jPushClient = new JPushClient(MASTER_SECRET, APP_KEY);

    @Autowired
    private JpushMapper jpushMapper;

    /**
     * 构建推送对象: 对Android平台，所有设备，内容为jpush的通知
     * @param jpush
     * @return
     * @throws Exception
     */
    @Override
    public int push(Jpush jpush) throws Exception{
        PushPayload pushPayload = PushPayload.newBuilder()
                .setPlatform(Platform.android())
                .setAudience(Audience.all())
                .setNotification(Notification.alert(jpush.getNotification()))
                .setMessage(Message.content(jpush.getMessage()))
                .build();

        try {
            PushResult pushResult = jPushClient.sendPush(pushPayload);
            jpush.setPlatform("android");
            jpush.setAudience("all");
            jpush.setMsg_id(pushResult.msg_id);
            jpush.setSendno(pushResult.sendno);
            logger.info("success");
            logger.info("推送内容的msg_id: " + pushResult.msg_id);
            logger.info("推送编号sendno: " + pushResult.sendno);
            jpush.setPlatform("android");
            return 1;  //推送成功返回1
        } catch (APIConnectionException e) {
            logger.info("connection error");
            e.printStackTrace();
            return 0; //推送失败返回0;
        } catch (APIRequestException e) {
            logger.info("request error");
            e.printStackTrace();
            return 0;  //推送失败返回0
        }

    }

    /**
     * 增加一条jpush记录
     * @param jpush
     * @return
     */
    @Override
    public int add(Jpush jpush) {
        return jpushMapper.add(jpush);
    }


    /**
     * 根据主键 push_id 查询记录
     * @param push_id
     * @return
     */
    @Override
    public Jpush getJPushById(Integer push_id) {
        return jpushMapper.getJPushById(push_id);
    }

    /**
     * 查询所有jpush记录
     * @param pageNum   当前页
     * @param pageSize  每页显示条数
     * @return
     */
    @Override
    public List<Jpush> getJPushList(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum, pageSize);   // 分页
        return jpushMapper.getJPushList();
    }

    /**
     * 根据通知内容Notification 查询记录
     * @param notification
     * @return
     */
    @Override
    public List<Jpush> getJPushListByNotification(String notification) {
        return jpushMapper.getJPushListByNotification(notification);
    }




}
