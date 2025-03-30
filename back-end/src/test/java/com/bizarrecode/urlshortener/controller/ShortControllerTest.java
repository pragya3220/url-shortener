package com.bizarrecode.urlshortener.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

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

import com.bizarrecode.urlshortener.model.Url;
import com.bizarrecode.urlshortener.service.UrlService;
import com.bizarrecode.urlshortener.service.UserUrlService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ShortController.class,secure=false)
public class ShortControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private UrlService urlService;
	
	@MockBean
	private UserUrlService userUrlService;
	
	@Test
	public void tesSaveUrl() throws Exception {
		
		String exmapleUrl = "{\"longUrl\":\"my longUrl\",\"shortUrl\":\"my shortUrl\"}";
		Url mockUrl = new Url(1L,"my longUrl","my shortUrl");
		Mockito.when(urlService.saveUrl(Mockito.any(Url.class))).thenReturn(mockUrl);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/short/add-url")
				.accept(MediaType.APPLICATION_JSON).content(exmapleUrl)
				.contentType(MediaType.APPLICATION_JSON);
	
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
	
	}
	
	@Test
	public void tesGetUrlListByUserId() throws Exception {
		
		String exmapleUrl = "[{\"longUrl\":\"my longUrl\",\"shortUrl\":\"my shortUrl\"},{\"longUrl\":\"my longUrl2\",\"shortUrl\":\"my shortUrl2\"}]";
		List<Url> mockUrlList = new ArrayList<Url>();
		mockUrlList.add(new Url(1L,"my longUrl1","my shortUrl1"));
		mockUrlList.add(new Url(1L,"my longUrl2","my shortUrl2"));
		List<Long> urlIdList = new ArrayList<Long>();
		urlIdList.add(1L);
		urlIdList.add(1L);
		Mockito.when(urlService.listUrlByIdIn(urlIdList)).thenReturn(mockUrlList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/v1/short/get-urls-by-user-id/1")
				.accept(MediaType.APPLICATION_JSON).content(exmapleUrl)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
	
	@Test
	public void tesGetUrlByShortUrl() throws Exception {
		
		String exmapleUrl = "{\"longUrl\":\"my longUrl\",\"shortUrl\":\"my shortUrl\"}";
		Url mockUrl = new Url(1L,"my longUrl","my shortUrl");
		
		Mockito.when(urlService.findUrlByShortUrl(mockUrl.getShortUrl())).thenReturn(mockUrl);
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.get("/api/v1/short/get-url-by-short-url/1")
				.accept(MediaType.APPLICATION_JSON).content(exmapleUrl)
				.contentType(MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	
	}
}
