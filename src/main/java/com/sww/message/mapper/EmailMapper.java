package com.sww.message.mapper;

import com.sww.message.entity.Email;
import org.apache.ibatis.annotations.*;


import java.util.Date;
import java.util.List;
import java.util.Map;

//@Mapper 这里可以使用@Mapper注解，但是每个mapper都加注解比较麻烦，所以统一配置@MapperScan在扫描路径在application类中
public interface EmailMapper {

    //使用java对象来作为插入的参数
    @Insert("insert into email(email_to, subject, text) values(#{email_to}, #{subject}, #{text})")
    int add(Email email);


    //根据主键查询所有
    @Select("SELECT * FROM email WHERE mail_id = #{mail_id}")
    @Results({
            @Result(property = "mail_id", column = "mail_id"),
            @Result(property = "email_to", column = "email_to"),
            @Result(property = "subject", column = "subject"),
            @Result(property = "text", column = "text"),
            @Result(property = "sendtime", column = "sendtime")
    })
    Email getEmailById(Integer mail_id);


    //查询所有记录
    @Select("SELECT * FROM email")
    @Results({
            @Result(property = "mail_id", column = "mail_id"),
            @Result(property = "email_to", column = "email_to"),
            @Result(property = "subject", column = "subject"),
            @Result(property = "text", column = "text"),
            @Result(property = "sendtime", column = "sendtime")
    })
    List<Email> getEmailList();

    //根据邮件主题 subject 查询记录
    @Select("SELECT * FROM email WHERE subject = #{subject}")
    @Results({
            @Result(property = "mail_id", column = "mail_id"),
            @Result(property = "email_to", column = "email_to"),
            @Result(property = "subject", column = "subject"),
            @Result(property = "text", column = "text"),
            @Result(property = "sendtime", column = "sendtime")
    })
    List<Email> getEmailListBySubject(@Param("subject") String subject);

    //根据收件人 email_to  查询记录
    @Select("SELECT * FROM email WHERE email_to = #{email_to}")
    @Results({
            @Result(property = "mail_id", column = "mail_id"),
            @Result(property = "email_to", column = "email_to"),
            @Result(property = "subject", column = "subject"),
            @Result(property = "text", column = "text"),
            @Result(property = "sendtime", column = "sendtime")
    })
    List<Email> getEmailListByEmail_to(@Param("email_to") String email_to);


    @Insert("INSERT INTO email(email_to, subject, text, sendtime) VALUES (#{email_to}, #{subject}, #{text}, #{sendtime})")
        //@Options(useGeneratedKeys = true, keyProperty = "mail_id")
    int insert(@Param("email_to") String email_to, @Param("subject") String subject, @Param("text") String text,
               @Param("sendtime") Date sendtime);


    //插入记录, 通过Map对象来传递参数
    @Insert("INSERT INTO email(from, to, subject, text, sendTime) values("+
            "#{from, jdbcType=VARCHAR}, #{to, jdbcType=VARCHAR}, #{subject, jdbcType=VARCHAR}, #{text, jdbcType=VARCHAR}," +
            "#{sendTime, jdbcType=TIMESTAMP})")
    int insertByMap(Map<String, Object> map);

    /*Email email = new Email();
        email.setTo("13576132451@163.com");
        email.setSubject("test");
        email.setText("test");

    */
}
