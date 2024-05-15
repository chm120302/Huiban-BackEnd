package com.example.huibanbackend.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Journal {
    private static final Logger log = LoggerFactory.getLogger(Journal.class);
    private Integer id;
    private String journalId;
    private String ccfRank;
    private String sub;
    private String dblpLink;
    private String mainpageLink;
    private Integer followNum;
    private double acceptedRate;
    private Integer sessionNum;
    private String topicDetails;
    private boolean isPostponed;

    public Journal(){}


    public Journal(Integer id, String journalId, String ccfRank, String sub, String dblpLink, String mainpageLink, Integer followNum, double acceptedRate, Integer sessionNum, String topicDetails, boolean isPostponed) {
        this.id = id;
        this.journalId = journalId;
        this.ccfRank = ccfRank;
        this.sub = sub;
        this.dblpLink = dblpLink;
        this.mainpageLink = mainpageLink;
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

    public String getJournalId() {
        return journalId;
    }

    public void setJournalId(String journalId) {
        this.journalId = journalId;
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

    public String getMainpageLink() {
        return mainpageLink;
    }

    public void setMainpageLink(String mainpageLink) {
        this.mainpageLink = mainpageLink;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public double getAcceptedRate() {
        return acceptedRate;
    }

    public void setAcceptedRate(double acceptedRate) {
        this.acceptedRate = acceptedRate;
    }

    public Integer getSessionNum() {
        return sessionNum;
    }

    public void setSessionNum(Integer sessionNum) {
        this.sessionNum = sessionNum;
    }

    public String getTopicDetails() {
        return topicDetails;
    }

    public void setTopicDetails(String topicDetails) {
        this.topicDetails = topicDetails;
    }

    public boolean isPostponed() {
        return isPostponed;
    }

    public void setPostponed(boolean postponed) {
        isPostponed = postponed;
    }

    @Override
    public String toString() {
        return "Journal{" +
                "id=" + id +
                ", journalId='" + journalId + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", dblpLink='" + dblpLink + '\'' +
                ", mainpageLink='" + mainpageLink + '\'' +
                ", followNum=" + followNum +
                ", acceptedRate=" + acceptedRate +
                ", sessionNum=" + sessionNum +
                ", topicDetails='" + topicDetails + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }
}
