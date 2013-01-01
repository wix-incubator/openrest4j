package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetChainsRequest extends Request {
	public static final String TYPE = "get_chains";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetChainsRequest() {}
    
    public GetChainsRequest(Set<String> fields) {
    	this.fields = fields;
    }

    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
