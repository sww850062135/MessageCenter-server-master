package com.sww.message.service.impl;


import com.sww.message.entity.User;
import com.sww.message.entity.User1;
import com.sww.message.mapper.UserMapper;
import com.sww.message.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User1 getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User1 getUserByUsername(String username) {
        return userMapper.getUserByUsername(username);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    /**
     * 更新管理员信息
     * @param user
     * @return
     */
    @Override
    public int update(User1 user) {
        return userMapper.update(user);
    }
}
