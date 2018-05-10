package com.sww.message.service;

import com.sww.message.entity.User;
import com.sww.message.entity.User1;

import java.util.List;

public interface UserService {
    User1 getUserById(Integer id);

    User1 getUserByUsername(String username);

    List<User> getUserList();

    //更新管理员信息
    int update(User1 user1);
}
