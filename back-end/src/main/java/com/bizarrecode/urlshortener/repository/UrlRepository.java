package com.bizarrecode.urlshortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizarrecode.urlshortener.model.Url;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long>  {

	public Url findOneByShortUrl(String shortUrl);
	public Url findOneByLongUrl(String longUrl);
	public List<Url> findByIdIn(List<Long> urlIdList);
	
}
