package com.bizarrecode.urlshortener.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user_url")
public class UserUrl {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id ;
	
	private Long userId ;
	
	private Long urlId ;
	

	public UserUrl() {
	}

	public UserUrl(Long id, Long userId, Long urlId) {
		this.id = id;
		this.userId = userId;
		this.urlId = urlId;
	}

	public UserUrl(Long userId, Long urlId) {
		super();
		this.userId = userId;
		this.urlId = urlId;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getUrlId() {
		return urlId;
	}

	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}


}
