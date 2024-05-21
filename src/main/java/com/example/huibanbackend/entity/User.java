package com.example.huibanbackend.entity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

public class User {
    private static final Logger log = LoggerFactory.getLogger(User.class);
    private Integer id;
    private String email;
    private String imageUrl;
    private String userName;
    private String institution;
    private String password;

    //用户关注会议列表
    private List<Conference> followConferences;
    //用户关注期刊列表
    private List<Journal> followJournals;
    //用户参加会议列表
    private List<Conference> attendConferences;
    //用户参加期刊列表
    private List<Journal> attendJournals;

    public User(){

    }

    public User(String email, String imageUrl, String userName, String institution, String password, List<Conference> followConferences, List<Journal> followJournals, List<Conference> attendConferences, List<Journal> attendJournals) {

        this.email = email;
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.institution = institution;
        this.password = password;
        this.followConferences = followConferences;
        this.followJournals = followJournals;
        this.attendConferences = attendConferences;
        this.attendJournals = attendJournals;
    }

    public List<Conference> getAttendConferences() {
        return attendConferences;
    }

    public void setAttendConferences(List<Conference> attendConferences) {
        this.attendConferences = attendConferences;
    }

    public List<Journal> getAttendJournals() {
        return attendJournals;
    }

    public void setAttendJournals(List<Journal> attendJournals) {
        this.attendJournals = attendJournals;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Conference> getFollowConferences() {
        return followConferences;
    }

    public void setFollowConferences(List<Conference> followConferences) {
        this.followConferences = followConferences;
    }

    public List<Journal> getFollowJournals() {
        return followJournals;
    }

    public void setFollowJournals(List<Journal> followJournals) {
        this.followJournals = followJournals;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getInstitution() {
        return institution;
    }
    public void setInstitution(String institution) {
        this.institution = institution;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", userName='" + userName + '\'' +
                ", institution='" + institution + '\'' +
                ", password='" + password + '\'' +
                ", followConferences=" + followConferences +
                ", followJournals=" + followJournals +
                ", attendConferences=" + attendConferences +
                ", attendJournals=" + attendJournals +
                '}';
    }
}
