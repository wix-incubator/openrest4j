package com.openrest.v1_1;

import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.HttpRequestFactory;
import com.wix.restaurants.jsonclient.JsonClient;

public class OpenrestProtocol {
	private final JsonClient jsonClient;
	
	public OpenrestProtocol(HttpRequestFactory requestFactory, Integer connectTimeout, Integer readTimeout) {
		jsonClient = new JsonClient(requestFactory, connectTimeout, readTimeout, 1);
	}
	
    public <T> T post(String url, Object obj, TypeReference<Response<T>> responseType) throws IOException, OpenrestException {
    	final Response<T> response = jsonClient.post(url, obj, responseType);
    	verifyResponse(response);
    	return response.value;
    }

    public JsonClient getJsonClient() {
    	return jsonClient;
    }
    
    private static <T> void verifyResponse(Response<T> response) throws OpenrestException {
    	if (response.error != null) {
    		throw new OpenrestException(response.error, response.errorMessage);
    	}
    }
}
