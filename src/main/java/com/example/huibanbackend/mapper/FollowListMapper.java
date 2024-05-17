package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.FollowList;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FollowListMapper {

    //按照email查询关注的会议/期刊
    List<FollowList> getByEmail(String email);

    //按照email和category查询关注的会议/期刊
    List<FollowList> getByCategory(@Param("email") String email, @Param("category") String category);

    //插入关注信息
    int insert(FollowList followList);

    //删除关注信息
    int delete(Integer id);

    //批量删除关注信息
    int deleteBatch(List<Integer> list);


}
