package com.example.huibanbackend.entity;

import java.util.Date;

public class SysRole {

    private String id;

    private String name;

    private String roleKey;

    private String status;

    private Integer delFlag;

    private Date createTime;

    private String remark;

    public SysRole(String id, String name, String roleKey, String status, Integer delFlag, Date createTime, String remark) {
        this.id = id;
        this.name = name;
        this.roleKey = roleKey;
        this.status = status;
        this.delFlag = delFlag;
        this.createTime = createTime;
        this.remark = remark;
    }

    public SysRole() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoleKey() {
        return roleKey;
    }

    public void setRoleKey(String roleKey) {
        this.roleKey = roleKey;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
