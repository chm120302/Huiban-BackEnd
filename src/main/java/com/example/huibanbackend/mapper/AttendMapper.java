package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.AttendList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Mapper
public interface AttendMapper {

    //插入参加会议
    int insertConf(AttendList attendList);


    //删除参加会议
    int deleteConf(@Param("conferenceId") String conferenceId, @Param("email") String email);

}
