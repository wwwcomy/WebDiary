package com.iteye.wwwcomy.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Used to save request diary
 * 
 * @author xingnan.liu
 */
public class DiaryDTOForRequest {
	// Should use this tag: "mvc:annotation-driven"
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	private String content;
	private String weather;
	private String title;

	public Date getDate() {
		return new Date(date.getTime());
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
}
