package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.util.StringUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.iteye.wwwcomy.model.exception.NotFoundException;

@JsonPropertyOrder({ "id", "date", "lastUpdateDate", "weather", "title", "content" })
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(content = Include.NON_NULL)
@Entity
public class Diary extends BasePersistedObject {

	private Date date;
	private long userId;
	private String weather;
	private String title;
	private String content;

	/**
	 * Gets the creation date of the Diary.
	 * 
	 * @return
	 */
	@JsonFormat(pattern = "yyyy-MM-dd")
	@Column(columnDefinition = "DATETIME")
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(columnDefinition = "TEXT")
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
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
	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public Diary update(Diary diary) {
		if (StringUtils.isEmpty(diary.getUserId()) || !(diary.getUserId() == this.getUserId())) {
			throw new NotFoundException(
					"The user was not found in the input diary, or the input diary's user is not the same as the existing one!");
		}
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
}
