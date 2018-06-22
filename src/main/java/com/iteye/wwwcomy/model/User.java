package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * 
 * @author xingnan.liu
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = Include.NON_NULL)
public class User extends BasePersistedObject {
	private String name; // 用户名
	private String deleted;// 是否已经删除
	private String email; // 电子邮箱
	private Date lasLogin;// 上次登录时间
	private String phone; // 电话
	private int status; // 状态（是否在线，是否通过验证为正式用户）

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

	@Column(columnDefinition = "DATETIME")
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
