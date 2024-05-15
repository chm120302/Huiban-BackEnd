package com.example.huibanbackend.entity;

public class FollowList {
    private Integer id;
    private String email;
    private String conferenceId;
    public FollowList() {

    }

    public FollowList(Integer id, String email, String conferenceId) {
        this.id = id;
        this.email = email;
        this.conferenceId = conferenceId;
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

    public String getConferenceId() {
        return conferenceId;
    }

    public void setConferenceId(String conferenceId) {
        this.conferenceId = conferenceId;
    }

    @Override
    public String toString() {
        return "FollowList{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", conferenceId='" + conferenceId + '\'' +
                '}';
    }
}
