package com.example.huibanbackend.controller;

import com.example.huibanbackend.entity.User;
import com.example.huibanbackend.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/user/list")
    public List<User> getUserList(){
        return userService.getAllInfo();
    }


}
