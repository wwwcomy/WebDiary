package com.iteye.wwwcomy.model;

import java.util.Date;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iteye.wwwcomy.model.exception.NotFoundException;

@SuppressWarnings("deprecation")
@JsonPropertyOrder({ "id", "date", "lastUpdateDate", "weather", "title", "content" })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class Diary {

	private String id;
	private String userId;

	private User user;
	private Date date;
	/**
	 * 上次更新日期
	 */
	private Date lastUpdateDate;
	/**
	 * 天气
	 */
	private String weather;
	private String title;
	private String content;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@JsonIgnore
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * Gets the creation date of the Diary.
	 * 
	 * @return
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@JsonIgnore
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Diary update(Diary diary) {
		if (StringUtils.isEmpty(diary.getUserId()) || !diary.getUserId().equals(this.getUserId())) {
			throw new NotFoundException(
					"The user was not found in the input diary, or the input diary's user is not the same as the existing one!");
		}
		setLastUpdateDate(new Date());
		if (null != diary.getContent()) {
			setContent(diary.getContent());
		}
		if (null != diary.getDate()) {
			setDate(diary.getDate());
		}
		if (null != diary.getTitle()) {
			setTitle(diary.getTitle());
		}
		return this;
	}

	@Override
	public String toString() {
		return "Diary content is:" + this.content;
	}
}
