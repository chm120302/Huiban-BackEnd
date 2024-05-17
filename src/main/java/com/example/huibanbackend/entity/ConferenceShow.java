package com.example.huibanbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ConferenceShow {
    private static final Logger log = LoggerFactory.getLogger(ConferenceShow.class);
    private Integer id;

    private String conferenceId; // 会议缩写+年份
    private String ccfRank;
    private String sub;
    private String dblpLink;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date abstractDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date paperDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date startTime;
    private float acceptedRate;
    private String place;
    private boolean isPostponed;

    public ConferenceShow() {

    }

    public boolean isPostponed() {
        return isPostponed;
    }

    public void setPostponed(boolean postponed) {
        isPostponed = postponed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getCcfRank() {
        return ccfRank;
    }

    public void setCcfRank(String ccfRank) {
        this.ccfRank = ccfRank;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getDblpLink() {
        return dblpLink;
    }

    public void setDblpLink(String dblpLink) {
        this.dblpLink = dblpLink;
    }

    public Date getAbstractDeadline() {
        return abstractDeadline;
    }

    public void setAbstractDeadline(Date abstractDeadline) {
        this.abstractDeadline = abstractDeadline;
    }

    public Date getPaperDeadline() {
        return paperDeadline;
    }

    public void setPaperDeadline(Date paperDeadline) {
        this.paperDeadline = paperDeadline;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public float getAcceptedRate() {
        return acceptedRate;
    }

    public void setAcceptedRate(float acceptedRate) {
        this.acceptedRate = acceptedRate;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "ConferenceShow{" +
                "id=" + id +
                ", conferenceId='" + conferenceId + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", dblpLink='" + dblpLink + '\'' +
                ", abstractDeadline=" + abstractDeadline +
                ", paperDeadline=" + paperDeadline +
                ", startTime=" + startTime +
                ", acceptedRate=" + acceptedRate +
                ", place='" + place + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }
}
