package io.krystof.nocodb.clients.rest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GameTableClient {

	public GameTableClient(RestTemplate restTemplate, String url) {
		super();
		this.restTemplate = restTemplate;
		this.url = url;
	}

	private RestTemplate restTemplate;

	private String url;

	public RestTemplate getRestTemplate() {
		return restTemplate;
	}

	public void setRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAllRecords() {
		HttpEntity<String> requestEntity = new HttpEntity<String>("");
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}

}
