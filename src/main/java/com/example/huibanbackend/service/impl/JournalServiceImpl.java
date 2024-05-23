package com.example.huibanbackend.service.impl;


import com.example.huibanbackend.entity.Journal;
import com.example.huibanbackend.entity.JournalDetail;
import com.example.huibanbackend.entity.JournalShow;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.JournalMapper;
import com.example.huibanbackend.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalMapper journalMapper;

    @Override
    public List<JournalDetail> getPopularList() {
        return journalMapper.getPopularList();
    }

    @Override
    public List<JournalShow> getRecentList() {
        return journalMapper.getRecentList();
    }

    @Override
    public List<JournalShow> getAllShow() {
        return journalMapper.getAllShow();
    }

    @Override
    public JournalShow getById(String journalId) {
        JournalShow js = journalMapper.getById(journalId);
        if(js == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return js;
    }

    @Override
    public List<JournalShow> getByCCFRank(String ccfRank) {
        return journalMapper.getByCCFRank(ccfRank);
    }

    @Override
    public List<JournalShow> getBySub(String sub) {
        return journalMapper.getBySub(sub);
    }

    @Override
    public List<JournalDetail> getAllDetail() {
        return journalMapper.getAllDetail();
    }

    @Override
    public JournalDetail getDetailById(String journalId) {
        JournalDetail jd = journalMapper.getDetailById(journalId);
        if(jd == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return jd;
    }

    @Override
    public int insert(Journal journal) {
        String journalId = journal.getJournalId();
        JournalShow js = journalMapper.getById(journalId);
        if(js != null){
            throw new DuplicateException("Journal with id " + journalId + " already exists");
        }
        return journalMapper.insert(journal);
    }

    @Override
    public int delete(String journalId) {
        JournalShow js = journalMapper.getById(journalId);
        if(js == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return journalMapper.delete(journalId);
    }

    @Override
    public int update(Journal journal) {
        String journalId = journal.getJournalId();
        JournalShow js = journalMapper.getById(journalId);
        if(js == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return journalMapper.update(journal);
    }

    @Override
    public int addFollowNum(String journalId) {
        JournalShow js = journalMapper.getById(journalId);
        if(js == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return journalMapper.addFollowNum(journalId);
    }

    @Override
    public int subFollowNum(String journalId) {
        JournalShow js = journalMapper.getById(journalId);
        if(js == null){
            throw new NotFoundException("Journal with id " + journalId + " not found");
        }
        return journalMapper.subFollowNum(journalId);
    }


}
