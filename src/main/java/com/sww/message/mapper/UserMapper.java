package com.sww.message.mapper;

import com.sww.message.entity.User;
import com.sww.message.entity.User1;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    @Select("SELECT * FROM user WHERE id = #{id}")
    User1 getUserById(Integer id);

    @Select("SELECT id,username,phone,email FROM user WHERE username = #{username}")
    User1 getUserByUsername(String username);

    @Select("SELECT * FROM user")
    List<User> getUserList();

    @Update("UPDATE user SET phone = #{phone}, email = #{email} WHERE id = #{id}")
    int update(User1 user);

}
