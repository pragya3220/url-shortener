package com.bizarrecode.urlshortener.service;

import java.util.List;

import com.bizarrecode.urlshortener.model.UserUrl;

public interface UserUrlService {
	
	public UserUrl saveUserUrl(UserUrl userUrl);
	public List<UserUrl> findUserUrlByUserId(Long userId);
	public List<UserUrl> findUserUrlByUserIdAndUrlId(Long userId, Long urlId);
	
}
