package com.iteye.wwwcomy.main;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author wwwcomy
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "dataroot")
public class DataRoot {
	@XmlElement(name = "book")
	private List<DiaryBean> diaries;

	public List<DiaryBean> getDiaries() {
		return diaries;
	}

	public void setDiaries(List<DiaryBean> diaries) {
		this.diaries = diaries;
	}

	@Override
	public String toString() {
		return diaries.toString();
	}
}
