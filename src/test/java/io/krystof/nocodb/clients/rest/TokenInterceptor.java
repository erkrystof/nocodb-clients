package io.krystof.nocodb.clients.rest;

import java.io.IOException;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

public class TokenInterceptor implements ClientHttpRequestInterceptor {
    
    private final Logger log = LoggerFactory.getLogger(this.getClass());
    
    private String tokenName;
    private String tokenValue;
  
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException 
    {
    	request.getHeaders().add(tokenName, tokenValue);
        ClientHttpResponse response = execution.execute(request, body);
        return response;
    }

	public String getTokenName() {
		return tokenName;
	}

	public void setTokenName(String tokenName) {
		this.tokenName = tokenName;
	}

	public String getTokenValue() {
		return tokenValue;
	}

	public void setTokenValue(String tokenValue) {
		this.tokenValue = tokenValue;
	}
  
  
}