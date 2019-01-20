package com.dvb.URLShortener.resource;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.dvb.URLShortener.model.URL;
import com.dvb.URLShortener.service.URLService;


@RestController
@RequestMapping("/api/v1/urls")
public class URLResource {
	
	@Autowired
	private URLService URLService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<URL>> getURL() {
		List<URL> urls = URLService.findAll();

		if (urls.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<List<URL>>(urls, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<URL> save(@RequestBody URL url, UriComponentsBuilder ucBuilder) {
		URLService.save(url);

		HttpHeaders header = new HttpHeaders();
		header.setLocation(ucBuilder.path("/api/v1/url/{id}").buildAndExpand(url.getId()).toUri());

		return new ResponseEntity<URL>(header, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<URL> getProductById(@PathVariable("id") Long id) {
		Optional<URL> url = URLService.findById(id);

		if (!url.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<URL>(url.get(), HttpStatus.OK);
	}

	@RequestMapping(value = "/shortUrl/{shortUrl}", method = RequestMethod.GET)
	public ResponseEntity<URL> getProductById(@PathVariable("shortUrl") String shortUrl) {
		Optional<URL> url = URLService.findByShortURL(shortUrl);

		if (!url.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<URL>(url.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<URL> delete(@PathVariable("id") Long id) {
		Optional<URL> url = URLService.findById(id);

		if (!url.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		URLService.delete(url.get());

		return new ResponseEntity<URL>(HttpStatus.NO_CONTENT);
	}
	
	

}
