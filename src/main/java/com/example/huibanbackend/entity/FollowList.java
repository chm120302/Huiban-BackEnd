package com.example.huibanbackend.entity;

public class FollowList {
    private String email;
    private String conferenceId;

    public FollowList(String email, String conferenceId) {
        this.email = email;
        this.conferenceId = conferenceId;
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
                "email='" + email + '\'' +
                ", conferenceId='" + conferenceId + '\'' +
                '}';
    }
}
