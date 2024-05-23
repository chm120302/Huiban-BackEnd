package com.example.huibanbackend.service.impl;


import com.example.huibanbackend.entity.FollowList;
import com.example.huibanbackend.mapper.FollowListMapper;
import com.example.huibanbackend.service.FollowListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowListServiceImpl implements FollowListService {

    @Autowired
    private FollowListMapper followListMapper;

    @Override
    public int insertConf(FollowList followList) {
        return followListMapper.insertConf(followList);
    }

    @Override
    public int insertJour(FollowList followList) {
        return followListMapper.insertJour(followList);
    }

    @Override
    public int deleteConf(String conferenceId, String email) {
        return followListMapper.deleteConf(conferenceId, email);
    }

    @Override
    public int deleteJour(String journalId, String email) {
        return followListMapper.deleteJour(journalId, email);
    }
}
