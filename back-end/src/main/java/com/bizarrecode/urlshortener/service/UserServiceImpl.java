package com.bizarrecode.urlshortener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.bizarrecode.urlshortener.model.User;
import com.bizarrecode.urlshortener.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepository userRepository;
	@Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.saveAndFlush(user);
	}

	@Override
	public User findUserById(Long id) {
		return userRepository.findOne(id);
	}

	
	@Override
	public User findUserByName(String username) {
		return userRepository.findOneByUsername(username);
	}

	
	
	
}
