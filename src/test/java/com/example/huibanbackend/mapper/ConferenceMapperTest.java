package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.Conference;
import com.example.huibanbackend.entity.ConferenceDetail;
import com.example.huibanbackend.entity.ConferenceShow;
import com.example.huibanbackend.utils.dateUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class ConferenceMapperTest {
    @Autowired
    private ConferenceMapper conferenceMapper;

    @Test
    void getPopularList() {
        List<ConferenceDetail> popularList = conferenceMapper.getPopularList();
        System.out.println("success");
//        List<HashMap<String, Integer>> popularList = conferenceMapper.getPopularList();
//        System.out.println("success");

    }

    @Test
    void getRecentList() {
        List<ConferenceShow> recentList = conferenceMapper.getRecentList();
        System.out.println("success");
    }

    @Test
    void getAllShow() {
        List<ConferenceShow> showList = conferenceMapper.getAllShow();
        System.out.println("success");
    }

    @Test
    void getById() {
        ConferenceShow c = conferenceMapper.getById("date2023");
        System.out.println("success");
    }

    @Test
    void getByCCFRank() {
        conferenceMapper.getByCCFRank("B");
    }

    @Test
    void getByTitle() {
        conferenceMapper.getByTitle("DATE");
    }

    @Test
    void getBySub() {
        conferenceMapper.getBySub("DS");
    }

    @Test
    void getByPeriod() throws ParseException {
        Date start = dateUtils.stringToDate("yyyy-MM-dd", "2020-01-01");
        Date end = dateUtils.stringToDate("yyyy-MM-dd", "2025-01-01");
        conferenceMapper.getByPeriod(start, end);
        System.out.println("success");
    }

    @Test
    void getAllDetail() {
        List<ConferenceDetail> dd = conferenceMapper.getAllDetail();
        System.out.println("success");
    }

    @Test
    void getDetailById() {
        ConferenceDetail c = conferenceMapper.getDetailById("date2023");
        System.out.println("success");
    }

    @Test
    void insert() throws ParseException {
        Conference c = new Conference();
        c.setConferenceId("infocom2024");
        c.setTitle("INFOCOM");
        c.setFullTitle("International Conference on Computer Communications");
        c.setCcfRank("A");
        c.setSub("computer networking");
        c.setYear(2024);
        c.setPlace("Vancouver, British Columbia, Canada");
        c.setStartTime(dateUtils.stringToDate("yyyy-MM-dd", "2024-05-20"));
        c.setTopicDetails("IEEE INFOCOM is a top-ranked networking conference of the IEEE Communications Society. IEEE INFOCOM 2024 solicits research papers describing significant and innovative research contributions to the field of computer and data communication networks. We invite submissions on a wide range of research topics, spanning both theoretical and systems research. Topics include but are not limited to:");
        conferenceMapper.insert(c);
        System.out.println("success");
    }

    @Test
    void delete() {
        conferenceMapper.delete("date2023");
        System.out.println("success");
    }

    @Test
    void update() {

        Conference c = new Conference();
        c.setConferenceId("date2023");
        c.setPostponed(true);
        conferenceMapper.update(c);
        System.out.println("success");

    }


}