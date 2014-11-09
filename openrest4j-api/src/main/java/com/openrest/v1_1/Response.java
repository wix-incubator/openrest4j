package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Response<T> implements Serializable {
	private static final long serialVersionUID = 1L;
	
    public Response(T value) {
        this.timestamp = new java.util.Date().getTime();
        this.value = value;
    }

    /** Default constructor for JSON deserialization. */
    public Response() {}

    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static Response fromException(OpenrestException e) {
        final Response response = new Response();
        response.timestamp = new java.util.Date().getTime();
        response.error = e.error();
        response.errorMessage = e.errorMessage();
        return response;
    }

    @SuppressWarnings("rawtypes")
	public static Response fromNullValue() {
        final Response response = new Response();
        response.timestamp = new java.util.Date().getTime();
        return response;
    }

    @JsonInclude(Include.NON_NULL)
    public Long timestamp;

    /** @see Error. */
    @JsonInclude(Include.NON_NULL)
    public String error;

    /** Detailed error information for debugging. */
    @JsonInclude(Include.NON_NULL)
    public String errorMessage;

    /** The returned value, if no error occurred. */
    @JsonInclude(Include.NON_NULL)
    public T value;
}
