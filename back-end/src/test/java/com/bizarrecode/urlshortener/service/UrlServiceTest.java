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

import com.bizarrecode.urlshortener.model.Url;

@RunWith(SpringRunner.class)
public class UrlServiceTest {
	
	@MockBean
	private UrlService urlService;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void tesSaveUrl() throws Exception {
		
		Url mockUrl = new Url(1L,"my longUrl","my shortUrl");
		Mockito.when(urlService.saveUrl(Mockito.any(Url.class))).thenReturn(mockUrl);
		
		Url result = urlService.saveUrl(mockUrl);
		assertEquals("my longUrl", result.getLongUrl());
		assertEquals("my shortUrl", result.getShortUrl());
		assertEquals(new Long(1L), result.getId());
	
	}
	
	@Test
	public void testGetUrlBylongUrl(){
		
		Url mockUrl = new Url(1L,"my longUrl","my shortUrl");
		Mockito.when(urlService.findUrlByLongUrl("my longUrl")).thenReturn(mockUrl);
		
		Url result = urlService.findUrlByLongUrl("my longUrl");
		assertEquals("my longUrl", result.getLongUrl());
		assertEquals("my shortUrl", result.getShortUrl());
		assertEquals(new Long(1L), result.getId());
	
	}
	
	@Test
	public void testGetUrlByShortUrl(){
		
		Url mockUrl = new Url(1L,"my longUrl","my shortUrl");
		Mockito.when(urlService.findUrlByShortUrl("my shortUrl")).thenReturn(mockUrl);
		
		Url result = urlService.findUrlByShortUrl("my shortUrl");
		assertEquals("my longUrl", result.getLongUrl());
		assertEquals("my shortUrl", result.getShortUrl());
		assertEquals(new Long(1L), result.getId());
	
	}
	
	@Test
	public void testGetAllUrlByUserId(){
		
		List<Long> urlIdList = new ArrayList<Long>();
		urlIdList.add(1L);
		urlIdList.add(2L);
		urlIdList.add(3L);
		List<Url> urlList = new ArrayList<Url>();
		urlList.add(new Url("my longUrl1","my shortUrl1"));
		urlList.add(new Url("my longUrl2","my shortUrl2"));
		urlList.add(new Url("my longUrl3","my shortUrl3"));
		Mockito.when(urlService.listUrlByIdIn(urlIdList)).thenReturn(urlList);
		
		List<Url> result = urlService.listUrlByIdIn(urlIdList);
		assertEquals(3, result.size());
	
	}
	
}
