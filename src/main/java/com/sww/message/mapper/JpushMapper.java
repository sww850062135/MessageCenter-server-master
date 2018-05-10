package com.sww.message.mapper;

import com.sww.message.entity.Jpush;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface JpushMapper {
    //增加一条推送记录
    @Insert("insert into jpush(platform, audience, notification, message, msg_id, sendno) " +
            "values(#{platform}, #{audience}, #{notification}, #{message}, #{msg_id}, #{sendno})")
    int add(Jpush jpush);


    //根据主键查询所有
    @Select("SELECT * FROM jpush WHERE mail_id = #{push_id}")
    @Results({
            @Result(property = "push_id", column = "push_id"),
            @Result(property = "platform", column = "platform"),
            @Result(property = "audience", column = "audience"),
            @Result(property = "notification", column = "notification"),
            @Result(property = "message", column = "message"),
            @Result(property = "msg_id", column = "msg_id"),
            @Result(property = "sendno", column = "sendno"),
            @Result(property = "pushtime", column = "pushtime")
    })
    Jpush getJPushById(Integer push_id);


    //查询所有记录
    @Select("SELECT * FROM jpush")
    @Results({
            @Result(property = "push_id", column = "push_id"),
            @Result(property = "platform", column = "platform"),
            @Result(property = "audience", column = "audience"),
            @Result(property = "notification", column = "notification"),
            @Result(property = "message", column = "message"),
            @Result(property = "msg_id", column = "msg_id"),
            @Result(property = "sendno", column = "sendno"),
            @Result(property = "pushtime", column = "pushtime")
    })
    List<Jpush> getJPushList();


    //根据subject查询记录
    @Select("SELECT * FROM jpush WHERE notification = #{notification}")
    @Results({
            @Result(property = "push_id", column = "push_id"),
            @Result(property = "platform", column = "platform"),
            @Result(property = "audience", column = "audience"),
            @Result(property = "notification", column = "notification"),
            @Result(property = "message", column = "message"),
            @Result(property = "msg_id", column = "msg_id"),
            @Result(property = "sendno", column = "sendno"),
            @Result(property = "pushtime", column = "pushtime")
    })
    List<Jpush> getJPushListByNotification(@Param("notification") String notification);
}
