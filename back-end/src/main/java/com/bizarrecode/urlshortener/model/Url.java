package com.bizarrecode.urlshortener.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="url")
public class Url implements Serializable{
	
	private static final long serialVersionUID = 102411811680040773L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	
	@Column(unique = true, length = 6144)
	private String longUrl;
	
	@Column(unique = true, length = 50)
	private String shortUrl;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;
	
	@Transient
	private Long userId;
	
	public Url() {
	}

	public Url(Long id, String longUrl, String shortUrl) {
		this.id = id;
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}


	public Url(String longUrl, String shortUrl) {
		this.longUrl = longUrl;
		this.shortUrl = shortUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLongUrl() {
		return longUrl;
	}

	public void setLongUrl(String longUrl) {
		this.longUrl = longUrl;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
