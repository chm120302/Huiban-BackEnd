package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.FollowList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class FollowListMapperTest {
    @Autowired
    FollowListMapper followListMapper;

    @Test
    void insertConf() {
        FollowList followList = new FollowList();
        followList.setEmail("chm120302@126.com");
        followList.setCategory("conference");
        followList.setAcademicId("KDD2024");
        followListMapper.insertConf(followList);
        System.out.println("success");

    }

    @Test
    void insertJour() {
        FollowList followList = new FollowList();
        followList.setEmail("xxx@163.com");
        followList.setCategory("journal");
        followList.setAcademicId("Future Generation Computer Systems");
        followListMapper.insertJour(followList);
        System.out.println("success");
    }

    @Test
    void deleteConf() {
        followListMapper.deleteConf(2);
        System.out.println("success");
    }

    @Test
    void deleteJour() {
        followListMapper.deleteJour(3);
        System.out.println("success");
    }
}