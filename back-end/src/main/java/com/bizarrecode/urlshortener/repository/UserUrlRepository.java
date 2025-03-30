package com.bizarrecode.urlshortener.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bizarrecode.urlshortener.model.UserUrl;

@Repository
public interface UserUrlRepository extends JpaRepository<UserUrl, Long> {

	public List<UserUrl> findByUserId(Long userId);
	public List<UserUrl> findByUserIdAndUrlId(Long userId, Long urlId);
	
}
