package com.dvb.URLShortener.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dvb.URLShortener.model.URL;
import com.dvb.URLShortener.repository.URLRepository;

@Service
public class URLService {
	
	@Autowired
	private URLRepository URLRepository;
	
	public void save(URL url) {
		url.setShortURL(RandomStringUtils.randomAlphanumeric(6));
		url.setShortURLBegin("http://dvb.com/");
		URLRepository.save(url);
	}
	
	public List<URL> findAll() {
		return (List<URL>) URLRepository.findAll();
	}
	
	public Optional<URL> findById(Long id) {
		return URLRepository.findById(id);
	}
	
	public Optional<URL> findByShortURL(String shortURL) {
		return URLRepository.findByShortURL(shortURL);
	}
	
	public void delete(URL url) {
		URLRepository.delete(url);
	}

}
