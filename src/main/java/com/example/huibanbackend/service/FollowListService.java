package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.FollowList;

public interface FollowListService {

    //插入关注会议
    int insertConf(FollowList followList);

    //插入关注期刊
    int insertJour(FollowList followList);

    //删除关注会议
    int deleteConf(String conferenceId, String email);

    //删除关注期刊
    int deleteJour(String journalId, String email);

}
