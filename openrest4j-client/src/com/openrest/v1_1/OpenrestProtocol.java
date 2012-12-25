package com.openrest.v1_1;

import java.io.IOException;

import org.codehaus.jackson.type.TypeReference;

import com.google.api.client.http.HttpRequestFactory;

public class OpenrestProtocol {
	private final RestJsonClient restJsonClient;
	
	public OpenrestProtocol(HttpRequestFactory requestFactory, Integer connectTimeout, Integer readTimeout) {
		restJsonClient = new RestJsonClient(requestFactory, connectTimeout, readTimeout);
	}
	
	public OpenrestProtocol(HttpRequestFactory requestFactory) {
		this(requestFactory, null, null);
	}
	
    public <T> T post(String url, Object obj, TypeReference<Response<T>> responseType) throws IOException, OpenrestException {
        try {
        	final Response<T> response = restJsonClient.post(url, obj, responseType);
        	verifyResponse(response);
        	return response.value;
        } catch (RestJsonHttpException e) {
            final Response<?> response = (Response<?>) e.value();
            if (response != null) {
                throw new OpenrestException(response.error, response.errorMessage, e);
            } else {
                throw e;
            }
        }
    }

    public RestJsonClient getRestJsonClient() {
    	return restJsonClient;
    }
    
    private static <T> void verifyResponse(Response<T> response) throws OpenrestException {
    	if (response.error != null) {
    		throw new OpenrestException(response.error, response.errorMessage);
    	}
    }
}
