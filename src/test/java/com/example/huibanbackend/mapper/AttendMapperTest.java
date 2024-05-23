package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.AttendList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class AttendMapperTest {
    @Autowired
    private AttendMapper attendMapper;

    @Test
    void insertConf() {
        AttendList attendList = new AttendList();
        attendList.setEmail("chm120302@126.com");
        attendList.setCategory("conference");
        attendList.setAcademicId("KDD2024");
        attendMapper.insertConf(attendList);
        System.out.println("success");

    }


    @Test
    void deleteConf() {
        attendMapper.deleteConf("date2023", "xxx");
        System.out.println("success");
    }


}