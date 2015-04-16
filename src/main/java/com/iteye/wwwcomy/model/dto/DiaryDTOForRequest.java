package com.iteye.wwwcomy.model.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * Used to save request diary
 * 
 * @author xingnan.liu
 * @version $Revision$
 */
public class DiaryDTOForRequest {
    // Should use this tag: "mvc:annotation-driven"
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date lastUpdateDate;
    private String content;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
