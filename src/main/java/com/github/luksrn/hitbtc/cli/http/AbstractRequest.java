package com.github.luksrn.hitbtc.cli.http;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.github.luksrn.hitbtc.cli.AuthenticationSession;

@Component
public abstract class AbstractRequest {

	@Autowired
	AuthenticationSession  auth;
	
	@Value("${hitbtc.env}")
	protected String hitbtcEnv;
	
	public RestTemplate restTemplate() {
		
		RestTemplate restTemplate = new RestTemplate();
		
		if(auth.isAuthenticated()) {
			restTemplate.getInterceptors().add(
	    		 new BasicAuthorizationInterceptor(auth.getTokens().getpKey(), auth.getTokens().getsKey()));
		}
	     
	    return restTemplate;
	}
	
	protected <T> T get(String url, Class<T> result) {
		HttpEntity<T> transactions = restTemplate().getForEntity(hitbtcEnv + url, result);	
		return transactions.getBody();
	}
	
	protected void delete(String url) {
		restTemplate().delete(hitbtcEnv + url);	
	}
	
	protected <T> T post(String url,  Object requestJson, Class<T> result) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);


		HttpEntity<?> entity = new HttpEntity<>(requestJson, headers);

		try {
			HttpEntity<T> transactions = restTemplate().postForEntity(hitbtcEnv + url, entity, result);	
			return transactions.getBody();
		} catch (HttpClientErrorException r) {
			// TODO 
			System.err.println("* " + r.getResponseBodyAsString() );
			throw r;
		}
	}
}
