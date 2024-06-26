package com.example.huibanbackend.service;

import com.example.huibanbackend.entity.Journal;
import com.example.huibanbackend.entity.JournalDetail;
import com.example.huibanbackend.entity.JournalShow;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface JournalService {

    //查询最受欢迎的5个期刊
    List<JournalDetail> getPopularList();

    //查询所有期刊信息(期刊展示页)
    List<JournalShow> getAllShow();

    //按照期刊id查询期刊(期刊展示页)
    JournalShow getById(String journalId);

    //按照ccf等级查询期刊(期刊展示页)
    List<JournalShow> getByCCFRank(String ccfRank);

    //按照期刊领域查询期刊(期刊展示页)
    List<JournalShow> getBySub(String sub);

    //查询所有期刊详情信息(期刊详情页)
    List<JournalDetail> getAllDetail();

    //按照id查询期刊详情(期刊详情页)
    JournalDetail getDetailById(String journalId);

    //插入期刊信息
    int insert(Journal journal);

    //删除期刊
    int delete(String journalId);

    //更新期刊信息
    int update(Journal journal);

    //更新收藏数
    int addFollowNum(@Param("journalId") String journalId);

    int subFollowNum(@Param("journalId")String journalId);


}
