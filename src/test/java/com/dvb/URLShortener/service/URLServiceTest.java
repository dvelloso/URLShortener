package com.dvb.URLShortener.service;

import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import com.dvb.URLShortener.model.URL;
import com.dvb.URLShortener.repository.URLRepository;

@RunWith(SpringRunner.class)
public class URLServiceTest {
	
    @TestConfiguration
    static class URLServiceTestContextConfiguration {
  
        @Bean
        public URLService urlService() {
            return new URLService();
        }
    }

    @Autowired
    private URLService urlService;
    
    @MockBean
    private URLRepository urlRepository;
    
    @Before
    public void setup(){
    	Optional<URL> url = Optional.of(new URL("www.uol.com.br", "1w2e3r", "http://dvb.com/"));
    	
    	Mockito.when(urlRepository.findByShortURL(url.get().getShortURL())).thenReturn(url);
    }
    
    @Test
    public void shouldReturnUol(){
    	String shortURL = "1w2e3r";
    	Optional<URL> url = urlService.findByShortURL(shortURL);
    	
    	Assert.assertEquals(shortURL, url.get().getShortURL());
    }

}
