package com.bizarrecode.urlshortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizarrecode.urlshortener.model.UserUrl;
import com.bizarrecode.urlshortener.repository.UserUrlRepository;

@Service("userUrlService")
public class UserUrlServiceImpl implements UserUrlService{
	
	@Autowired
	UserUrlRepository userUrlRepository;
	
	@Override
	public UserUrl saveUserUrl(UserUrl userUrl) {
		return userUrlRepository.saveAndFlush(userUrl);
	}

	@Override
	public List<UserUrl>  findUserUrlByUserId(Long userId) {
		return userUrlRepository.findByUserId(userId);
	}

	@Override
	public List<UserUrl>  findUserUrlByUserIdAndUrlId(Long userId, Long urlId) {
		return userUrlRepository.findByUserIdAndUrlId(userId, urlId);
	}

}
