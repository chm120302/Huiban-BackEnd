package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.AttendList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AttendMapper {

    //插入参加会议
    int insertConf(AttendList attendList);

    //插入参加期刊
    int insertJour(AttendList attendList);

    //删除参加会议
    int deleteConf(Integer id);

    //删除参加期刊
    int deleteJour(Integer id);

//    //批量删除参加信息
//    int deleteBatch(List<Integer> list);
}
