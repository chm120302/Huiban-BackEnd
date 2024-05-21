package com.example.huibanbackend.service.impl;


import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.mapper.UserMapper;
import com.example.huibanbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public List<User> getAllInfo() {
        return userMapper.getAllInfo();
    }

    @Override
    public User getAllInfoByEmail(String email) {
        return userMapper.getAllInfoByEmail(email);
    }

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int delete(Integer id) {
        return userMapper.delete(id);
    }

    @Override
    public int update(User user) {
        return userMapper.update(user);
    }

    @Override
    public int updatePassword(String email, String password) {
        return userMapper.updatePassword(email, password);
    }
}
