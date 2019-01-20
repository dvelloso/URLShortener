package com.dvb.URLShortener.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dvb.URLShortener.model.URL;

@Repository
public interface URLRepository extends CrudRepository<URL, Long>{

	public Optional<URL> findByShortURL(String shortURL);
}
