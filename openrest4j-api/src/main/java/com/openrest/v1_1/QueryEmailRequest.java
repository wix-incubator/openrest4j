package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryEmailRequest extends Request {
	public static final String TYPE = "query_email";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryEmailRequest() {}
    
    public QueryEmailRequest(String email) {
    	this.email = email;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String email;
}
