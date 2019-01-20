package com.dvb.URLShortener.repository;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.URLShortener.model.URL;
import com.dvb.URLShortener.repository.URLRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class URLRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private URLRepository urlRepository;

	@Test
	public void shouldReturnUrlUol() {
		URL url = new URL("www.uol.com.br", "1w2e3r", "http://dvb.com/");
		entityManager.persist(url);
		entityManager.flush();
		
		Optional<URL> found = urlRepository.findByShortURL("1w2e3r");
		
		Assert.assertEquals(url.getCompleteURL(), found.get().getCompleteURL());

	}

}

