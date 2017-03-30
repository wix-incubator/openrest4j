package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Feedback;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubmitFeedbackRequest extends Request {
	public static final String TYPE = "feedback";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubmitFeedbackRequest() {}
    
    public SubmitFeedbackRequest(String accessToken, Feedback feedback) {
    	this.accessToken = accessToken;
    	this.feedback = feedback;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Feedback feedback;
}
