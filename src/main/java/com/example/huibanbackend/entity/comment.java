package com.example.huibanbackend.entity;
import java.util.Date;

public class comment {
    private int commentId;
    private String email;
    private Date commentTime;
    private String content;
    private int lastId;
    private String conferenceId;

    public comment(int commentId, String email, Date commentTime, String content, int lastId, String conferenceId) {
        this.commentId = commentId;
        this.email = email;
        this.commentTime = commentTime;
        this.content = content;
        this.lastId = lastId;
        this.conferenceId = conferenceId;
    }

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLastId() {
        return lastId;
    }

    public void setLastId(int lastId) {
        this.lastId = lastId;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
    public String toString() {
        return "comment{" +
                "commentId=" + commentId +
                ", email='" + email + '\'' +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", lastId=" + lastId +
                ", conferenceId='" + conferenceId + '\'' +
                '}';
    }
}
