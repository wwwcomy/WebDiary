package com.iteye.wwwcomy.main;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "book")
public class DiaryBean {
	private String year;
	private String month;
	private String day;
	private Date date;
	private String icoid;
	private String icotext;
	private String week;
	private String title;
	private String memo;

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getIcoid() {
		return icoid;
	}

	public void setIcoid(String icoid) {
		this.icoid = icoid;
	}

	public String getIcotext() {
		return icotext;
	}

	public void setIcotext(String icotext) {
		this.icotext = icotext;
	}

	public String getWeek() {
		return week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	@Override
	public String toString() {
		return this.date.toString();
	}

}
