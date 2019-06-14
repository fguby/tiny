package com.mall.tiny.mbg.model;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
    @ApiModelProperty(value = "用户编号")
    private Integer userId;

    @ApiModelProperty(value = "用户姓名")
    private String userName;

    @ApiModelProperty(value = "用户密码")
    private String password;

    @ApiModelProperty(value = "用户手机号")
    private String phone;

    @ApiModelProperty(value = "用户邮箱")
    private String email;

    @ApiModelProperty(value = "注册时间")
    private Date registerTime;

    @ApiModelProperty(value = "上次登陆时间")
    private Date lastLoginTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", lastLoginTime=").append(lastLoginTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}