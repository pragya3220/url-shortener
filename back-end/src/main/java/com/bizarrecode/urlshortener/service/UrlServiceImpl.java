package com.bizarrecode.urlshortener.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bizarrecode.urlshortener.model.Url;
import com.bizarrecode.urlshortener.repository.UrlRepository;

@Service("urlService")
public class UrlServiceImpl implements UrlService{

	@Autowired
	UrlRepository urlRepository;
	
	@Override
	public Url saveUrl(Url url) {
		return urlRepository.saveAndFlush(url);
	}

	@Override
	public Url findUrlByLongUrl(String longUrl) {
		return urlRepository.findOneByLongUrl(longUrl);
	}

	@Override
	public Url findUrlByShortUrl(String shortUrl) {
		return urlRepository.findOneByShortUrl(shortUrl);
	}

	@Override
	public List<Url> listUrlByIdIn(List<Long> urlIdList) {
		return urlRepository.findByIdIn(urlIdList);
	}

}
