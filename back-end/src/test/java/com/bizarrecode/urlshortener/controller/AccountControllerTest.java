package com.bizarrecode.urlshortener.controller;


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.bizarrecode.urlshortener.model.User;
import com.bizarrecode.urlshortener.service.UserService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class,secure=false)
public class AccountControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UserService userService;
	
	String exmapleUser = "{\"username\":\"my username\",\"password\":\"my password\",\"fullName\":\"my fullName\"}";
	
	@Test
	public void tesRegister() throws Exception {
		
		User mockUser = new User("my username","my password","my fullName");
		Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(mockUser);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/account/register")
				.accept(MediaType.APPLICATION_JSON).content(exmapleUser)
				.contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	
	}

}
