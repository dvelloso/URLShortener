package com.dvb.URLShortener.resource;

import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.dvb.URLShortener.model.URL;
import com.dvb.URLShortener.service.URLService;

@RunWith(SpringRunner.class)
@WebMvcTest(URLResource.class)
public class URLResourceTest {
	
	@Autowired
	private MockMvc mvc;

	@MockBean
	private URLService urlService;
	
	@Test
	public void shouldReturnAllUrls() throws Exception {
		Optional<URL> url1 = Optional.of(new URL("www.uol.com.br", "1w2e3r", "http://dvb.com/"));
		Optional<URL> url2 = Optional.of(new URL("www.globo.com", "7u8i9o", "http://dvb.com/"));
		List<URL> urls = new ArrayList<>();
		urls.add(url1.get());
		urls.add(url2.get());
		
		BDDMockito.given(urlService.findAll()).willReturn(urls);

		mvc.perform(MockMvcRequestBuilders.get("/api/v1/urls")//
				.contentType(MediaType.APPLICATION_JSON))//
				.andExpect(MockMvcResultMatchers.status().isOk())//
				.andExpect(MockMvcResultMatchers.jsonPath("$", hasSize(greaterThanOrEqualTo(2))))//
				.andExpect(jsonPath("$[0].completeURL", is(url1.get().getCompleteURL())))//
				.andExpect(jsonPath("$[1].completeURL", is(url2.get().getCompleteURL())));

	}

}
