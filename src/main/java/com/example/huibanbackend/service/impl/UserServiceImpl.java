package com.example.huibanbackend.service.impl;


import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.UserMapper;
import com.example.huibanbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        User user = userMapper.getAllInfoByEmail(email);
        if (user == null) {
            // 该用户不在数据库中
            throw new NotFoundException("User with email " + email + " not found");
        }
        return user;
    }

    @Override
    public int insert(User user) {
        String email = user.getEmail();
        User selectUser = userMapper.getByEmail(email);
        if (selectUser != null) {
            // 若用户邮箱已经在数据库中
            throw new DuplicateException("User with email " + user.getEmail() + " already exists");
        }
        return userMapper.insert(user);
    }

    @Override
    public int delete(String email) {
       User user = userMapper.getByEmail(email);
       if (user == null) {
           throw new NotFoundException("User with email " + email + " not found");
       }
       return userMapper.delete(email);
    }

    @Override
    public int update(User user) {
        String email = user.getEmail();
        User selectUser = userMapper.getByEmail(email);
        if (selectUser == null) {
            // 该用户不在数据库中
            throw new NotFoundException("User with email " + email + " not found");
        }
        return userMapper.update(user);
    }

    @Override
    public int updatePassword(String email, String password) {
        User user = userMapper.getByEmail(email);
        if (user == null) {
            throw new NotFoundException("User with email " + email + " not found");
        }
        return userMapper.updatePassword(email, password);
    }
}
