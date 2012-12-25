package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Feedback feedback;
}
