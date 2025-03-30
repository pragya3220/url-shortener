package com.bizarrecode.urlshortener.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.bizarrecode.urlshortener.model.UserUrl;

@RunWith(SpringRunner.class)
public class UserUrlServiceTest {
	
	@MockBean
	private UserUrlService userUrlService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void tesSaveUserUrl() throws Exception {
		
		UserUrl mockUserUrl = new UserUrl(1L, 1L, 1L);
		Mockito.when(userUrlService.saveUserUrl(Mockito.any(UserUrl.class))).thenReturn(mockUserUrl);
		
		UserUrl result = userUrlService.saveUserUrl(mockUserUrl);
		assertEquals(new Long(1L), result.getUserId());
		assertEquals(new Long(1L), result.getUrlId());
	
	}
	
	@Test
	public void testGetUserUrlByUserId(){
		
		List<UserUrl> userUrlList = new ArrayList<UserUrl>();
		userUrlList.add(new UserUrl(1L, 1L, 1L));
		userUrlList.add(new UserUrl(2L, 1L, 2L));
		userUrlList.add(new UserUrl(3L, 1L, 3L));
		Mockito.when(userUrlService.findUserUrlByUserId(1L)).thenReturn(userUrlList);
		
		List<UserUrl> result = userUrlService.findUserUrlByUserId(1L);
		assertEquals(3, result.size());
	
	}
	
	@Test
	public void testGetUserUrlByUrlId(){
		
		List<UserUrl> userUrlList = new ArrayList<UserUrl>();
		userUrlList.add(new UserUrl(1L, 1L, 1L));
		userUrlList.add(new UserUrl(2L, 2L, 1L));
		userUrlList.add(new UserUrl(3L, 3L, 2L));
		Mockito.when(userUrlService.findUserUrlByUserIdAndUrlId(1L, 1L)).thenReturn(userUrlList);
		
		List<UserUrl> result = userUrlService.findUserUrlByUserIdAndUrlId(1L, 1L);
		assertEquals(3, result.size());
	
	}
	
}
