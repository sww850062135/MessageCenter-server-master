package com.sww.message.service;

import com.sww.message.entity.Jpush;

import java.util.List;

public interface JpushService {

    int add(Jpush jpush); //增加一条jpush记录

    int push(Jpush jpush) throws Exception; //构建推送对象: 对Android平台，所有设备，内容为jpush的通知

    Jpush getJPushById(Integer push_id); //根据主键 push_id 来查询push记录

    List<Jpush> getJPushList(int pageNum, int pageSize);   //查询push记录列表

    List<Jpush> getJPushListByNotification(String notification); //根据Notification 查询push记录列表

}
