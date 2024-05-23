package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.Conference;
import com.example.huibanbackend.entity.ConferenceDetail;
import com.example.huibanbackend.entity.ConferenceShow;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public interface ConferenceService {

    //查询最受欢迎的5个会议
    List<ConferenceDetail> getPopularList();
//    List<HashMap<String, Integer>> getPopularList();

    //查询截稿日期最近的前10个会议
    List<ConferenceShow> getRecentList();

    //查询所有会议信息(会议展示页)
    List<ConferenceShow> getAllShow();

    //按照会议id查询会议(会议展示页)
    ConferenceShow getById(String conferenceId);

    //按照ccf等级查询会议(会议展示页)
    List<ConferenceShow> getByCCFRank(String ccfRank);

    //按照会议缩写查询会议(会议展示页)
    List<ConferenceShow> getByTitle(String title);

    //按照会议领域查询会议(会议展示页)
    List<ConferenceShow> getBySub(String sub);

    //查询某段时间内的会议(会议展示页)
    List<ConferenceShow> getByPeriod(@Param("start") Date start, @Param("end") Date end);

    //查询所有会议详情信息(会议详情页)
    List<ConferenceDetail> getAllDetail();

    //按照id查询会议详情(会议详情页)
    ConferenceDetail getDetailById(String conferenceId);

    //插入会议信息
    int insert(Conference conference);

    //删除会议
    int delete(String conferenceId);

    //更新会议
    int update(Conference conference);

    //更新收藏数
    int addFollowNum(@Param("conferenceId") String conferenceId);

    int subFollowNum(@Param("conferenceId")String conferenceId);

    //更新参加数
    int addAttendNum(@Param("conferenceId")String conferenceId);

    int subAttendNum(@Param("conferenceId")String conferenceId);


}
