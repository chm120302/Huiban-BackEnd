package com.example.huibanbackend.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JournalDetail {
    private static final Logger log = LoggerFactory.getLogger(JournalDetail.class);
    private Integer id;
    private String journalId;
    private String ccfRank;
    private String sub;
    private String dblpLink;
    private String mainpageLink;
    private Integer followNum;
    private Double impactFactor;
    private String publisher;
    private String topicDetails;
    private Double citeScore;

    public JournalDetail() {
    }

    public JournalDetail(Integer id, String journalId, String ccfRank, String sub, String dblpLink, String mainpageLink, Integer followNum, Double impactFactor, String publisher, String topicDetails, Double citeScore) {
        this.id = id;
        this.journalId = journalId;
        this.ccfRank = ccfRank;
        this.sub = sub;
        this.dblpLink = dblpLink;
        this.mainpageLink = mainpageLink;
        this.followNum = followNum;
        this.impactFactor = impactFactor;
        this.publisher = publisher;
        this.topicDetails = topicDetails;
        this.citeScore = citeScore;
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

    public Double getImpactFactor() {
        return impactFactor;
    }

    public void setImpactFactor(Double impactFactor) {
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

    public Double getCiteScore() {
        return citeScore;
    }

    public void setCiteScore(Double citeScore) {
        this.citeScore = citeScore;
    }

    @Override
    public String toString() {
        return "JournalDetail{" +
                "id=" + id +
                ", journalId='" + journalId + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", dblpLink='" + dblpLink + '\'' +
                ", mainpageLink='" + mainpageLink + '\'' +
                ", followNum=" + followNum +
                ", impactFactor=" + impactFactor +
                ", publisher='" + publisher + '\'' +
                ", topicDetails='" + topicDetails + '\'' +
                ", citeScore=" + citeScore +
                '}';
    }
}
