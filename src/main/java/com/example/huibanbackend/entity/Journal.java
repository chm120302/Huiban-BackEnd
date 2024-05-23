package com.example.huibanbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Journal {
    private static final Logger log = LoggerFactory.getLogger(Journal.class);
    private Integer id;
    private String journalId;
    private String ccfRank;
    private String sub;
    private String dblpLink;
    private String mainpageLink;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "UTC")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date paperDeadline;
    private Integer followNum;
    private Double impactFactor;
    private String publisher;
    private String topicDetails;
    private Boolean isPostponed;

    public Journal(){}

    public Journal(String journalId, String ccfRank, String sub, String dblpLink, String mainpageLink, Date paperDeadline, Integer followNum, Double impactFactor, String publisher, String topicDetails, Boolean isPostponed) {

        this.journalId = journalId;
        this.ccfRank = ccfRank;
        this.sub = sub;
        this.dblpLink = dblpLink;
        this.mainpageLink = mainpageLink;
        this.paperDeadline = paperDeadline;
        this.followNum = followNum;
        this.impactFactor = impactFactor;
        this.publisher = publisher;
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



    public Double getImpactFactor() {
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

    public Boolean isPostponed() {
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
                ", paperDeadline=" + paperDeadline +
                ", followNum=" + followNum +
                ", impactFactor=" + impactFactor +
                ", publisher='" + publisher + '\'' +
                ", topicDetails='" + topicDetails + '\'' +
                ", isPostponed=" + isPostponed +
                '}';
    }
}
