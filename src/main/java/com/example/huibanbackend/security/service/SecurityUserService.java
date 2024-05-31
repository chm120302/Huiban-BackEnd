package com.example.huibanbackend.security.service;

import com.example.huibanbackend.entity.LoginUser;

public interface SecurityUserService {

    LoginUser login(String username, String password);

    void logout();
}
