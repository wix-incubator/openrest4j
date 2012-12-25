package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryEmailRequest extends Request {
	public static final String TYPE = "query_email";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryEmailRequest() {}
    
    public QueryEmailRequest(String email) {
    	this.email = email;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String email;
}
