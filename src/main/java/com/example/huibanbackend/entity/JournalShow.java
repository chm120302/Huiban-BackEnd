package com.example.huibanbackend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class JournalShow {
    private static final Logger log = LoggerFactory.getLogger(JournalShow.class);
    private Integer id;
    private String journalId;
    private String ccfRank;
    private String sub;
    private Double impactFactor;
    private String publisher;
    private Double citeScore;

    public JournalShow(){

    }

    public JournalShow(Integer id, String journalId, String ccfRank, String sub, Double impactFactor, String publisher, Double citeScore) {
        this.id = id;
        this.journalId = journalId;
        this.ccfRank = ccfRank;
        this.sub = sub;
        this.impactFactor = impactFactor;
        this.publisher = publisher;
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

    public Double getCiteScore() {
        return citeScore;
    }

    public void setCiteScore(Double citeScore) {
        this.citeScore = citeScore;
    }

    @Override
    public String toString() {
        return "JournalShow{" +
                "id=" + id +
                ", journalId='" + journalId + '\'' +
                ", ccfRank='" + ccfRank + '\'' +
                ", sub='" + sub + '\'' +
                ", impactFactor=" + impactFactor +
                ", publisher='" + publisher + '\'' +
                ", citeScore=" + citeScore +
                '}';
    }
}
