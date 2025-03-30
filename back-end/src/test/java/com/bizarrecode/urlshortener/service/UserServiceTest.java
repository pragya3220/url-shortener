package com.bizarrecode.urlshortener.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bizarrecode.urlshortener.model.User;

@RunWith(SpringRunner.class)
public class UserServiceTest {

	@MockBean
	private UserService userService;
	
	@Test
	public void tesRegister() throws Exception {
		
		User mockUser = new User("my username","my password","my fullName");
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(mockUser);
		
		User result = userService.saveUser(mockUser);
		assertEquals("my username", result.getUsername());
		assertEquals("my password", result.getPassword());
		assertEquals("my fullName", result.getFullName());
	
	}
}
