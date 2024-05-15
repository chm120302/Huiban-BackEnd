package com.example.huibanbackend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Date;

public class Conference {
    private static final Logger log = LoggerFactory.getLogger(Conference.class);
    private Integer id;
    private String conferenceId; // 会议缩写+年份
    private String title;
    private String fullTitle;
    private String ccfRank;
    private String sub;
    private Integer year;
    private String dblpLink;
    private String mainpageLink;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date abstractDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date paperDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date startTime;
    private Integer followNum;
    private double acceptedRate;
    private Integer sessionNum;
    private String topicDetails;
    private boolean isPostponed;

    public Conference() {}

    public Conference(Integer id, String conferenceId, String title, String fullTitle, String ccfRank, String sub, Integer year, String dblpLink, String mainpageLink, String place, Date abstractDeadline, Date paperDeadline, Date startTime, Integer followNum, double acceptedRate, Integer sessionNum, String topicDetails, boolean isPostponed) {
        this.id = id;
        this.conferenceId = conferenceId;
        this.title = title;
        this.fullTitle = fullTitle;
        this.ccfRank = ccfRank;
        this.sub = sub;
        this.year = year;
        this.dblpLink = dblpLink;
        this.mainpageLink = mainpageLink;
        this.place = place;
        this.abstractDeadline = abstractDeadline;
        this.paperDeadline = paperDeadline;
        this.startTime = startTime;
        this.followNum = followNum;
        this.acceptedRate = acceptedRate;
        this.sessionNum = sessionNum;
        this.topicDetails = topicDetails;
        this.isPostponed = isPostponed;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public void setSessionNum(Integer sessionNum) {
        this.sessionNum = sessionNum;
    }

    public boolean isPostponed() {
        return isPostponed;
    }

    public void setPostponed(boolean postponed) {
        isPostponed = postponed;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String description) {
        this.fullTitle = description;
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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDblpLink() {
        return dblpLink;
    }

    public void setDblpLink(String dblpLink) {
        this.dblpLink = dblpLink;
    }

    public String getMainpageLink() {
        return mainpageLink;
    }

    public void setMainpageLink(String mainpageLink) {
        this.mainpageLink = mainpageLink;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
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

    public int getFollowNum() {
        return followNum;
    }

    public void setFollowNum(int followNum) {
        this.followNum = followNum;
    }

    public double getAcceptedRate() {
        return acceptedRate;
    }

    public void setAcceptedRate(double acceptedRate) {
        this.acceptedRate = acceptedRate;
    }

    public int getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(int sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getTopicDetails() {
        return topicDetails;
    }

    public void setTopicDetails(String topicDetails) {
        this.topicDetails = topicDetails;
    }

    @Override
    public String toString() {
        return "Conference{" +
                "id=" + id +
                ", conferenceId='" + conferenceId + '\'' +
                ", title='" + title + '\'' +
                ", fullTitle='" + fullTitle + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", year=" + year +
                ", dblpLink='" + dblpLink + '\'' +
                ", mainpageLink='" + mainpageLink + '\'' +
                ", place='" + place + '\'' +
                ", abstractDeadline=" + abstractDeadline +
                ", paperDeadline=" + paperDeadline +
                ", startTime=" + startTime +
                ", followNum=" + followNum +
                ", acceptedRate=" + acceptedRate +
                ", sessionNum=" + sessionNum +
                ", topicDetails='" + topicDetails + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }
}
