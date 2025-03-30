package com.bizarrecode.urlshortener.service;

import java.util.List;

import com.bizarrecode.urlshortener.model.Url;

public interface UrlService {
	
	public Url saveUrl(Url url);
	public Url findUrlByLongUrl(String longUrl);
	public Url findUrlByShortUrl(String shortUrl);
	public List<Url> listUrlByIdIn(List<Long> urlIdList);
}
