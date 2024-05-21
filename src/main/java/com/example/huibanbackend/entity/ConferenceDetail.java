package com.example.huibanbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class ConferenceDetail {
    private static final Logger log = LoggerFactory.getLogger(ConferenceDetail.class);
    private Integer id;
    private String conferenceId; // 会议缩写+年份
    private String fullTitle;
    private String ccfRank;
    private String dblpLink;
    private String mainpageLink;
    private String place;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date abstractDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date paperDeadline;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date startTime;
    private int followNum;
    private Integer attendNum;
    private int sessionNum;
    private String topicDetails;
    private boolean isPostponed;

    public ConferenceDetail(String conferenceId, String fullTitle, String ccfRank, String dblpLink, String mainpageLink, String place, Date abstractDeadline, Date paperDeadline, Date startTime, int followNum, Integer attendNum, int sessionNum, String topicDetails, boolean isPostponed) {

        this.conferenceId = conferenceId;
        this.fullTitle = fullTitle;
        this.ccfRank = ccfRank;
        this.dblpLink = dblpLink;
        this.mainpageLink = mainpageLink;
        this.place = place;
        this.abstractDeadline = abstractDeadline;
        this.paperDeadline = paperDeadline;
        this.startTime = startTime;
        this.followNum = followNum;
        this.attendNum = attendNum;
        this.sessionNum = sessionNum;
        this.topicDetails = topicDetails;
        this.isPostponed = isPostponed;
    }

    public boolean isPostponed() {
        return isPostponed;
    }

    public Integer getAttendNum() {
        return attendNum;
    }

    public void setAttendNum(Integer attendNum) {
        this.attendNum = attendNum;
    }

    public void setPostponed(boolean postponed) {
        isPostponed = postponed;
    }

    public ConferenceDetail() {

    }

    public String getDblpLink() {
        return dblpLink;
    }

    public void setDblpLink(String dblpLink) {
        this.dblpLink = dblpLink;
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

    public String getFullTitle() {
        return fullTitle;
    }

    public void setFullTitle(String fullTitle) {
        this.fullTitle = fullTitle;
    }

    public String getCcfRank() {
        return ccfRank;
    }

    public void setCcfRank(String ccfRank) {
        this.ccfRank = ccfRank;
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
        return "ConferenceDetail{" +
                "id=" + id +
                ", conferenceId='" + conferenceId + '\'' +
                ", fullTitle='" + fullTitle + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", dblpLink='" + dblpLink + '\'' +
                ", mainpageLink='" + mainpageLink + '\'' +
                ", place='" + place + '\'' +
                ", abstractDeadline=" + abstractDeadline +
                ", paperDeadline=" + paperDeadline +
                ", startTime=" + startTime +
                ", followNum=" + followNum +
                ", attendNum=" + attendNum +
                ", sessionNum=" + sessionNum +
                ", topicDetails='" + topicDetails + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }
}
