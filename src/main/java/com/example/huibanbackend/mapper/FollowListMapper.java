package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.FollowList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface FollowListMapper {

    //插入关注会议
    int insertConf(FollowList followList);

    //插入关注期刊
    int insertJour(FollowList followList);

    //删除关注会议
    int deleteConf(Integer id);

    //删除关注期刊
    int deleteJour(Integer id);


//    //批量删除关注信息
//    int deleteBatch(List<Integer> list);


}
