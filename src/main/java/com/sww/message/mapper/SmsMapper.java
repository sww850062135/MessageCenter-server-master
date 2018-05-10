package com.sww.message.mapper;

import com.sww.message.entity.Sms;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface SmsMapper {

    //增加一条记录
    @Insert("insert into sms(mobile, templateid, smsType, sms_content, sms_status, sendtime, temp, uid)" +
            "values(#{mobile}, #{templateid}, #{smsType}, #{sms_content}, #{sms_status}, #{sendtime}, #{temp}, #{uid})")
    int add(Sms sms);


    //查询所有记录
    @Select("SELECT * FROM sms")
    @Results({
            @Result(property = "sms_id", column = "sms_id"),
            @Result(property = "mobile", column = "mobile"),
            @Result(property = "templateid", column = "templateid"),
            @Result(property = "smsType", column = "smsType"),
            @Result(property = "sms_content", column = "sms_content"),
            @Result(property = "sms_status", column = "sms_status"),
            @Result(property = "sendtime", column = "sendtime"),
            @Result(property = "temp", column = "temp"),
            @Result(property = "uid", column = "uid")
    })
    List<Sms> getSmsList();

    //根据手机号mobile查询记录
    @Select("SELECT * FROM sms WHERE mobile = #{mobile}")
    List<Sms> getSmsListByMobile(@Param("mobile") String mobile);
}
