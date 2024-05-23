package com.example.huibanbackend.service.impl;


import com.example.huibanbackend.entity.AttendList;
import com.example.huibanbackend.mapper.AttendMapper;
import com.example.huibanbackend.service.AttendListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AttendListServiceImpl implements AttendListService {

    @Autowired
    private AttendMapper attendMapper;

    @Override
    public int insertConf(AttendList attendList) {
        return attendMapper.insertConf(attendList);
    }

    @Override
    public int deleteConf(String conferenceId, String email) {
        return attendMapper.deleteConf(conferenceId, email);
    }
}
