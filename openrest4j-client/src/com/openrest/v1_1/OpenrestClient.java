package com.openrest.v1_1;

import java.io.IOException;

import org.codehaus.jackson.type.TypeReference;

import com.google.api.client.http.HttpRequestFactory;

/**
 * The Openrest client.
 * @author DL
 */
public class OpenrestClient {
    private final String apiUrl;
    private final OpenrestProtocol protocol;
    
    public OpenrestClient(HttpRequestFactory requestFactory, String apiUrl, Integer connectTimeout, Integer readTimeout) {
        this.apiUrl = apiUrl;
        protocol = new OpenrestProtocol(requestFactory, connectTimeout, readTimeout);
    }
    
    public OpenrestClient(HttpRequestFactory requestFactory, String apiUrl) {
        this(requestFactory, apiUrl, null, null);
    }
    
    public <T> T request(Request request, TypeReference<Response<T>> responseType) throws IOException, OpenrestException {
        return protocol.post(apiUrl, request, responseType);
    }
}
