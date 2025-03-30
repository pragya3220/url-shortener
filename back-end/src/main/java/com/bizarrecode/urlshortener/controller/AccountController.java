package com.bizarrecode.urlshortener.controller;

import java.security.Principal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bizarrecode.urlshortener.model.User;
import com.bizarrecode.urlshortener.service.UserService;
import com.bizarrecode.urlshortener.util.CustomError;

@CrossOrigin
@RestController
@RequestMapping("api/v1/account")
public class AccountController {

	public static final Logger logger = LoggerFactory.getLogger(AccountController.class);
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody User newUser) {
		if (userService.findUserByName(newUser.getUsername()) != null) {
			logger.error("username Already exist " + newUser.getUsername());
			return new ResponseEntity<CustomError>(new CustomError("user with username " + newUser.getUsername() + "already exist "),
					HttpStatus.CONFLICT);
		}
		newUser.setRole("USER");
		return new ResponseEntity<User>(userService.saveUser(newUser), HttpStatus.CREATED);
	}

	@RequestMapping("/login")
	public Principal user(Principal principal) {
		logger.info("user logged "+principal);
		return principal;
	}

	
}
