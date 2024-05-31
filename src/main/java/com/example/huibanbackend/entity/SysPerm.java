package com.example.huibanbackend.entity;

import java.util.Date;

public class SysPerm {

    private String id;

    private String funcName;

    private String path;

    private String status;

    private String perms;

    private Date createTime;

    private Integer delFlag;

    private String remark;

    public SysPerm(String id, String funcName, String path, String status, String perms, Date createTime, Integer delFlag, String remark) {
        this.id = id;
        this.funcName = funcName;
        this.path = path;
        this.status = status;
        this.perms = perms;
        this.createTime = createTime;
        this.delFlag = delFlag;
        this.remark = remark;
    }

    public SysPerm() {
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getId() {
        return id;
    }

    public String getFuncName() {
        return funcName;
    }

    public String getPath() {
        return path;
    }

    public String getStatus() {
        return status;
    }

    public String getPerms() {
        return perms;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public String getRemark() {
        return remark;
    }
}