package com.openrest.v1_1;

import com.fasterxml.jackson.core.type.TypeReference;
import com.google.api.client.http.HttpRequestFactory;

import java.io.IOException;

/** The Openrest client. */
public class OpenrestClient {
    private final String apiUrl;
    private final OpenrestProtocol protocol;

    public OpenrestClient(HttpRequestFactory requestFactory, Integer connectTimeout, Integer readTimeout,
                          Integer numberOfRetries, String apiUrl) {
        this.apiUrl = apiUrl;
        protocol = new OpenrestProtocol(requestFactory, connectTimeout, readTimeout, numberOfRetries);
    }
    
    public <T> T request(Request request, TypeReference<Response<T>> responseType) throws IOException, OpenrestException {
        return protocol.post(apiUrl, request, responseType);
    }
}
