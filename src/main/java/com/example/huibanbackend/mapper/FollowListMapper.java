package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.FollowList;

import java.util.List;

public interface FollowListMapper {
    List<FollowList> getAll();

    List<FollowList> getByEmail(String email);

    int insert(FollowList followList);

    int delete(String conferenceId);

    int deleteBatch(List<String> list);


}
