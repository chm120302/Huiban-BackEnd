package com.example.huibanbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class JournalDetail {
    private static final Logger log = LoggerFactory.getLogger(JournalDetail.class);
    private Integer id;
    private String journalId;
    private String ccfRank;
    private String sub;
    private String mainpageLink;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    private Date paperDeadline;
    private Integer followNum;
    private double acceptedRate;
    private double impactFactor;
    private String publisher;
    private String topicDetails;
    private boolean isPostponed;

    public JournalDetail() {
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

    public String getMainpageLink() {
        return mainpageLink;
    }

    public void setMainpageLink(String mainpageLink) {
        this.mainpageLink = mainpageLink;
    }

    public Date getPaperDeadline() {
        return paperDeadline;
    }

    public void setPaperDeadline(Date paperDeadline) {
        this.paperDeadline = paperDeadline;
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

    public double getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(double impactFactor) {
        this.impactFactor = impactFactor;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
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
        return "JournalDetail{" +
                "id=" + id +
                ", journalId='" + journalId + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", mainpageLink='" + mainpageLink + '\'' +
                ", paperDeadline=" + paperDeadline +
                ", followNum=" + followNum +
                ", acceptedRate=" + acceptedRate +
                ", impactFactor=" + impactFactor +
                ", publisher='" + publisher + '\'' +
                ", topicDetails='" + topicDetails + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }


}