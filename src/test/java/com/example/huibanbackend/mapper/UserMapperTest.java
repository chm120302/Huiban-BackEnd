package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class UserMapperTest {
    public User user;

    @Autowired
    public UserMapper userMapper;

    @Test
    void getAllInfo() {
        userMapper.getAllInfo();
        System.out.println("success");
    }

    @Test
    void getAllInfoByEmail() {
        user = userMapper.getAllInfoByEmail("chm120302@126.com");
        System.out.println("success");
    }

    @Test
    void getAll() {
        userMapper.getAll();
        System.out.println("success");
    }

    @Test
    void getByEmail() {
        user = userMapper.getByEmail("chm120302@126.com");
        System.out.println("success");

    }

    @Test
    void insert() {
        user = new User();
        user.setEmail("admin2@126.com");
        user.setPassword("123456");
        user.setImageUrl("https://ts1.cn.mm.bing.net/th/id/R-C.6b9074faed6dae2a0457e690c2aa3a03?rik=6V%2fv2rXhPCf7Pg&riu=http%3a%2f%2fn.sinaimg.cn%2fsinacn20115%2f534%2fw1280h854%2f20190221%2f9461-htknpmf9890147.jpg&ehk=RyGDdQrMiIWbz7Uxa%2fLSPOz2iXvM8JpbkBIZgttQkWc%3d&risl=&pid=ImgRaw&r=0");
        user.setUserName("admin2");
        user.setInstitution("ECNU");

        userMapper.insert(user);
        System.out.println("success");
    }

    @Test
    void delete() {
        user = userMapper.getByEmail("admin2@126.com");
    }

    @Test
    void update() {
        user = userMapper.getByEmail("chm120302@126.com");
        user.setInstitution("ecnu");
        userMapper.update(user);
        System.out.println("success");
    }

    @Test
    void updatePassword() {

//        userMapper.updatePassword("chm120302@126.com", "111111");
        System.out.println("success");
    }
}