package com.openrest.v1_1;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpContent;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;

/**
 * A client for a RESTful web-service that supports JSON representations.
 * @author DL
 */
public class RestJsonClient {
    private static final ObjectMapper mapper = new ObjectMapper();
    
    private final Integer connectTimeout;
    private final Integer readTimeout;
    private final HttpRequestFactory requestFactory;

    public RestJsonClient(HttpRequestFactory requestFactory, Integer connectTimeout, Integer readTimeout) {
    	this.requestFactory = requestFactory;
    	this.connectTimeout = connectTimeout;
    	this.readTimeout = readTimeout;
    }
    
    public RestJsonClient(HttpRequestFactory requestFactory) {
    	this(requestFactory, null, null);
    }

    public <T> T post(String url, Object requestObj, TypeReference<T> responseType) throws IOException {
    	final HttpContent content = new ByteArrayContent("application/json", mapper.writeValueAsString(requestObj).getBytes("UTF-8"));
    	
    	final HttpRequest request = requestFactory.buildPostRequest(new GenericUrl(url), content);
        if (connectTimeout != null) {
        	request.setConnectTimeout(connectTimeout.intValue());
        }
        if (readTimeout != null) {
        	request.setReadTimeout(readTimeout);
        }
        request.getHeaders().setAccept("application/json");

        request.setThrowExceptionOnExecuteError(false);
        final HttpResponse response = request.execute();
        try {
            return parseJsonResponse(response, responseType);
        } finally {
        	response.ignore();
        }
    }

    public <T> Image getImage(String url, TypeReference<T> responseType) throws IOException {
		final HttpRequest request = requestFactory.buildGetRequest(new GenericUrl(url));
        if (connectTimeout != null) {
        	request.setConnectTimeout(connectTimeout.intValue());
        }
        if (readTimeout != null) {
        	request.setReadTimeout(readTimeout);
        }

        request.setThrowExceptionOnExecuteError(false);
        final HttpResponse response = request.execute();
        try {
            return parseImageResponse(response, responseType);
        } finally {
        	response.ignore();
        }
    }

    private static <T> T parseJsonResponse(HttpResponse response, TypeReference<T> responseType) throws IOException {
    	if (!response.isSuccessStatusCode()) {
            final BufferedReader br = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
            try {
                throw new RestJsonHttpException(response.getStatusCode(), streamToObject(br, responseType));
            } finally {
                br.close();
            }
    	}
    	
        final BufferedReader br = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
        try {
            return streamToObject(br, responseType);
        } finally {
            br.close();
        }
    }

    private static <T> Image parseImageResponse(HttpResponse response, TypeReference<T> responseType) throws IOException {
    	if (!response.isSuccessStatusCode()) {
            final BufferedReader br = new BufferedReader(new InputStreamReader(response.getContent(), "UTF-8"));
            try {
                throw new RestJsonHttpException(response.getStatusCode(), streamToObject(br, responseType));
            } finally {
                br.close();
            }
    	}
    	
        final String contentType = response.getContentType();
        final byte[] content = new byte[response.getHeaders().getContentLength().intValue()];

        final DataInputStream dis = new DataInputStream(new BufferedInputStream(response.getContent()));
        try {
            dis.readFully(content);
        } finally {
            dis.close();
        }

        return new Image(contentType, content);
    }

    private static <T> T streamToObject(BufferedReader br, TypeReference<T> responseType) throws IOException {
        // Make sure the entire response is read (allows connection reuse)
        T response = null;
        String line;
        while ((line = br.readLine()) != null) {
            if ((line.length() > 0) && (line.charAt(0) == '{')) {
                response = mapper.readValue(line, responseType);
            }
        }
        return response;
    }
}
