package com.example.huibanbackend.entity;

public class User {
    private String email;
    private String imageUrl;
    private String userName;
    private String institution;
    private String password;

    public User(String email, String imageUrl, String userName, String institution, String password) {
        this.email = email;
        this.imageUrl = imageUrl;
        this.userName = userName;
        this.institution = institution;
        this.password = password;
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
        return "User [email=" + email + ", imageUrl=" + imageUrl + ", userName=" + userName;
    }


}
