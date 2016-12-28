package com.iteye.wwwcomy.model;

import java.util.Date;

/**
 * 
 * @author xingnan.liu
 */
public class User {
    private long userid; // 用户ID

    private Date createdDate;
    private String deleted;// 是否已经删除
    private String email; // 电子邮箱
    private Date lasLogin;// 上次登录时间
    private String name; // 用户名
    private String password; // 用户密码
    private String salt;
    private String phone; // 电话
    private int status; // 状态（是否在线，是否通过验证为正式用户）

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDeleted() {
        return deleted;
    }

    public void setDeleted(String deleted) {
        this.deleted = deleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getLasLogin() {
        return lasLogin;
    }

    public void setLasLogin(Date lasLogin) {
        this.lasLogin = lasLogin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User:" + this.name;
    }

}
