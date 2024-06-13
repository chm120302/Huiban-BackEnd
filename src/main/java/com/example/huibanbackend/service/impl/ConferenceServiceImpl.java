package com.example.huibanbackend.service.impl;

import com.example.huibanbackend.entity.Conference;
import com.example.huibanbackend.entity.ConferenceDetail;
import com.example.huibanbackend.entity.ConferenceShow;
import com.example.huibanbackend.exception.DuplicateException;
import com.example.huibanbackend.exception.NotFoundException;
import com.example.huibanbackend.mapper.ConferenceMapper;
import com.example.huibanbackend.service.ConferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ConferenceServiceImpl implements ConferenceService {

    @Autowired
    private ConferenceMapper conferenceMapper;

    @Override
    public List<ConferenceDetail> getPopularList(){
        return conferenceMapper.getPopularList();
    }

    @Override
    public List<ConferenceShow> getRecentList() {
        return conferenceMapper.getRecentList();
    }

    @Override
    public List<ConferenceShow> getAllShow() {
        return conferenceMapper.getAllShow();
    }

    @Override
    public ConferenceShow getById(String conferenceId) {
        ConferenceShow  cs = conferenceMapper.getById(conferenceId);
        if(cs == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return cs;
    }

    @Override
    public List<ConferenceShow> getByCCFRank(String ccfRank) {
        List<ConferenceShow> cs = conferenceMapper.getByCCFRank(ccfRank);
        return cs;
    }


    @Override
    public List<ConferenceShow> getByTitle(String title) {
        List<ConferenceShow> cs = conferenceMapper.getByTitle(title);
        return cs;
    }

    @Override
    public List<ConferenceShow> getBySub(String sub) {
        List<ConferenceShow> cs = conferenceMapper.getBySub(sub);
        return cs;
    }

    @Override
    public List<ConferenceShow> getByPeriod(Date start, Date end) {
        List<ConferenceShow> cs = conferenceMapper.getByPeriod(start, end);
        return cs;
    }

    @Override
    public List<ConferenceDetail> getAllDetail() {
        List<ConferenceDetail> cs = conferenceMapper.getAllDetail();
        return cs;
    }

    @Override
    public ConferenceDetail getDetailById(String conferenceId) {
        ConferenceDetail cd = conferenceMapper.getDetailById(conferenceId);
        if(cd == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return cd;
    }

    @Override
    public int insert(Conference conference) {
        String conferenceId = conference.getConferenceId();
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c != null){
            //若会议已经在数据库中
            throw new DuplicateException("Conference with id " + conferenceId + " already exist");
        }
        return conferenceMapper.insert(conference);
    }

    @Override
    public int delete(String conferenceId) {
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.delete(conferenceId);
    }

    @Override
    public int update(Conference conference) {
        String conferenceId = conference.getConferenceId();
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.update(conference);
    }

    @Override
    public int addFollowNum(String conferenceId) {
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.addFollowNum(conferenceId);
    }

    @Override
    public int subFollowNum(String conferenceId) {
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.subFollowNum(conferenceId);
    }

    @Override
    public int addAttendNum(String conferenceId) {
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.addAttendNum(conferenceId);
    }

    @Override
    public int subAttendNum(String conferenceId) {
        ConferenceShow c = conferenceMapper.getById(conferenceId);
        if(c == null){
            throw new NotFoundException("Conference with id " + conferenceId + " not found");
        }
        return conferenceMapper.subAttendNum(conferenceId);
    }
}
