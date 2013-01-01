package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDistributorsRequest extends Request {
	public static final String TYPE = "get_distributors";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetDistributorsRequest() {}
    
    public GetDistributorsRequest(Set<String> fields) {
    	this.fields = fields;
    }

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
