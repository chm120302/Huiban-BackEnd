package com.example.huibanbackend.entity;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AttendList {
    private static final Logger log = LoggerFactory.getLogger(FollowList.class);
    private Integer id;
    private String email;
    private String category;
    private String academicId;
    public AttendList() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    @Override
    public String toString() {
        return "AttendList{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", category='" + category + '\'' +
                ", academicId='" + academicId + '\'' +
                '}';
    }


}
