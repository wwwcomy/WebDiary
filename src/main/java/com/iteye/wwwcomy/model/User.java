package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author xingnan.liu
 */
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userid; // 用户ID

    private String username; // 用户名
    private String password; // 用户密码
    private String email; // 电子邮箱
    private String phone; // 电话
    private int status; // 状态（是否在线，是否通过验证为正式用户）
    private Date last_login;// 上次登录时间
    private int deleted;// 是否已经删除
    private Date created_date;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
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

    public Date getLast_login() {
        return last_login;
    }

    public void setLast_login(Date lastLogin) {
        last_login = lastLogin;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date createdDate) {
        created_date = createdDate;
    }

}
