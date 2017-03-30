package com.wix.restaurants.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Property;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetPropertyRequest extends Request {
	public static final String TYPE = "set_property";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetPropertyRequest() {}
    
    public SetPropertyRequest(String accessToken, Property property, Set<String> fields) {
    	this.accessToken = accessToken;
    	this.property = property;
    	this.fields = fields;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Property property;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
