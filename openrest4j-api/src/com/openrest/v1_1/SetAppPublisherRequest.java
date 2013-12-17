package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetAppPublisherRequest extends Request {
    public static final String TYPE = "set_app_publisher";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetAppPublisherRequest() {}
    
    public SetAppPublisherRequest(String accessToken, String distributorId, AppPublisher appPublisher) {
    	this.accessToken = accessToken;
    	this.distributorId = distributorId;
    	this.appPublisher = appPublisher;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    @JsonInclude(Include.NON_NULL)
    public AppPublisher appPublisher;
}
