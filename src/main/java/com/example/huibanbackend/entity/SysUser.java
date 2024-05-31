package com.example.huibanbackend.entity;

public class SysUser {

    private String email;

    private String password;

    public SysUser(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public SysUser() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
