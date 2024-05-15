package com.example.huibanbackend.entity;


import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class Comment {
    private Integer id;
    private String userName;
    private String imageUrl;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "UTC")
    private Date commentTime;

    private String content;
    private String category;
    private String academicId;
    private Integer parentId;

    //回复评论
    private List<Comment> replys = new ArrayList<>();
    private Comment parentComment;
    private String parentUsername;
    private String parentImageurl;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", commentTime=" + commentTime +
                ", content='" + content + '\'' +
                ", category='" + category + '\'' +
                ", academicId='" + academicId + '\'' +
                ", parentId=" + parentId +
                ", replys=" + replys +
                ", parentComment=" + parentComment +
                ", parentUsername='" + parentUsername + '\'' +
                ", parentImageurl='" + parentImageurl + '\'' +
                '}';
    }

    public Comment(){

    }

    public Comment(Integer id, String userName, String imageUrl, Date commentTime, String content, String category, String academicId, Integer parentId, List<Comment> replys, Comment parentComment, String parentUsername, String parentImageurl) {
        this.id = id;
        this.userName = userName;
        this.imageUrl = imageUrl;
        this.commentTime = commentTime;
        this.content = content;
        this.category = category;
        this.academicId = academicId;
        this.parentId = parentId;
        this.replys = replys;
        this.parentComment = parentComment;
        this.parentUsername = parentUsername;
        this.parentImageurl = parentImageurl;
    }

    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAcademicId() {
        return academicId;
    }

    public void setAcademicId(String academicId) {
        this.academicId = academicId;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public List<Comment> getReplys() {
        return replys;
    }

    public void setReplys(List<Comment> replys) {
        this.replys = replys;
    }

    public Comment getParentComment() {
        return parentComment;
    }

    public void setParentComment(Comment parentComment) {
        this.parentComment = parentComment;
    }

    public String getParentUsername() {
        return parentUsername;
    }

    public void setParentUsername(String parentUsername) {
        this.parentUsername = parentUsername;
    }

    public String getParentImageurl() {
        return parentImageurl;
    }

    public void setParentImageurl(String parentImageurl) {
        this.parentImageurl = parentImageurl;
    }

}
