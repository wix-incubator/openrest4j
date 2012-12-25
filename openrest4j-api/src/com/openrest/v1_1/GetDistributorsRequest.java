package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDistributorsRequest extends Request {
	public static final String TYPE = "get_distributors";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetDistributorsRequest() {}
    
    public GetDistributorsRequest(Set<String> fields) {
    	this.fields = fields;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Set<String> fields;
}
