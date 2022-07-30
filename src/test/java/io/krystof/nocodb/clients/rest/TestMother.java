package io.krystof.nocodb.clients.rest;

import org.springframework.web.client.RestTemplate;

public class TestMother {
	public static RestTemplate generateRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		TokenInterceptor ti = new TokenInterceptor();
		ti.setTokenName(System.getProperty("NocoDbTokenKey"));
		ti.setTokenValue(System.getProperty("NocoDbTokenValue"));
		restTemplate.getInterceptors().add(0, ti);
		return restTemplate;
	}
}
