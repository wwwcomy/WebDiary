package com.iteye.wwwcomy.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

/**
 * Indicates a MappedSuperclass which contains createdTime, createdBy,
 * modifiedTime, updateBy and Identifier.
 * 
 * All the persisted classes should extend this class.
 * 
 * @author wwwcomy@gmail.com
 *
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BasePersistedObject {

	private long id;
	private Date createdTime;
	private String createdBy;
	private Date modifiedTime;
	private String updatedBy;

	@Id
	@GeneratedValue()
	@Column(unique = true, nullable = false)
	@JsonProperty(access = Access.READ_ONLY)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@JsonProperty(access = Access.READ_ONLY)
	@CreatedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATETIME")
	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	@JsonProperty(access = Access.READ_ONLY)
	@CreatedBy
	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@JsonProperty(access = Access.READ_ONLY)
	@LastModifiedDate
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition = "DATETIME")
	public Date getModifiedTime() {
		return modifiedTime;
	}

	public void setModifiedTime(Date modifiedTime) {
		this.modifiedTime = modifiedTime;
	}

	@JsonProperty(access = Access.READ_ONLY)
	@LastModifiedBy
	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
}
