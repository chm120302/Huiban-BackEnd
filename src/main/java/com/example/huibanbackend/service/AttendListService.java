package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.AttendList;

public interface AttendListService {


    //插入参加会议
    int insertConf(AttendList attendList);

    //删除参加会议
    int deleteConf(String conferenceId, String email);
}
