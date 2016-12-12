package com.iteye.wwwcomy.model;

import java.util.Date;

/**
 * 
 * @author xingnan.liu
 */
public class User {
    private int userid; // 用户ID

    private String username; // 用户名
    private String password; // 用户密码
    private String email; // 电子邮箱
    private String phone; // 电话
    private int status; // 状态（是否在线，是否通过验证为正式用户）
    private Date lasLogin;// 上次登录时间
    private int deleted;// 是否已经删除
    private Date createdDate;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Date getLastLogin() {
        return lasLogin;
    }

    public void setLastLogin(Date lastLogin) {
        lasLogin = lastLogin;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
