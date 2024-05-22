package com.example.huibanbackend.mapper;

import com.example.huibanbackend.entity.Journal;
import com.example.huibanbackend.entity.JournalDetail;
import com.example.huibanbackend.entity.JournalShow;
import com.example.huibanbackend.utils.dateUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.ParseException;
import java.util.HashMap;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
class JournalMapperTest {
    @Autowired
    private JournalMapper journalMapper;

    @Test
    void getPopularList() {
        List<HashMap<String, Integer>> list = journalMapper.getPopularList();
        System.out.println("success");

    }

    @Test
    void getRecentList() {
        List<JournalShow> list = journalMapper.getRecentList();
        System.out.println("success");
    }

    @Test
    void getAllShow() {
        List<JournalShow> list = journalMapper.getAllShow();
        System.out.println("success");
    }

    @Test
    void getById() {
        JournalShow j = journalMapper.getById("IEEE Journal on Selected Areas in Communications");
        System.out.println("success");

    }

    @Test
    void getByCCFRank() {
        List<JournalShow> list = journalMapper.getByCCFRank("A");
        System.out.println("success");
    }

    @Test
    void getBySub() {
        List<JournalShow> list = journalMapper.getBySub("computer networking");
        System.out.println("success");
    }

    @Test
    void getAllDetail() {
        List<JournalDetail> list = journalMapper.getAllDetail();
        System.out.println("success");
    }

    @Test
    void getDetailById() {
        JournalDetail j = journalMapper.getDetailById("IEEE Journal on Selected Areas in Communications");
        System.out.println("success");
    }

    @Test
    void insert() throws ParseException {
        Journal j = new Journal();
        j.setJournalId("Computer Networks");
        j.setCcfRank("B");
        j.setSub("computer networking");
        j.setImpactFactor(4.474);
        j.setPaperDeadline(dateUtils.stringToDate("yyyy-MM-dd", "2024-06-15"));
        journalMapper.insert(j);
        System.out.println("success");
    }


    @Test
    void delete() {
        journalMapper.delete(4);
        System.out.println("success");
    }

    @Test
    void update() {
        Journal j = new Journal();
        j.setJournalId("IEEE Journal on Selected Areas in Communications");
        j.setPostponed(true);
        journalMapper.update(j);
        System.out.println("success");
    }


}