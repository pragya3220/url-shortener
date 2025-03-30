package com.bizarrecode.urlshortener.service;

import com.bizarrecode.urlshortener.model.User;

public interface UserService {

	public User saveUser(User user);
	public User findUserById(Long id);
	public User findUserByName(String username);
	
	
}
