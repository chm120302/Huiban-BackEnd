package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.Conference;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface ConferenceMapper {
    List<Conference> getAll();

    List<Conference> getAllShow();

    Conference getById(String conferenceId);

    List<Conference> getByCCFRank(String ccfRank);

    List<Conference> getByTitle(String title);

    List<Conference> getByFullTitle(String fullTitle);

    List<Conference> getBySub(String sub);

    List<Conference> getByYear(int year);

    List<Conference> getByPeriod(@Param("start") Date start, @Param("end") Date end);

    List<Conference> getAllDetail();

    Conference getDetailById(String conferenceId);

    int insert(Conference conference);

    int insertBatch(List<Conference> list);

    int delete(String conferenceId);

    int update(Conference conference);

    int updateThreeTime(@Param("conferenceId") String conferenceId, @Param("abstractDeadline") Date abstractDeadline,
                        @Param("paperDeadline") Date paperDeadline, @Param("startTime") Date startTime);


}
