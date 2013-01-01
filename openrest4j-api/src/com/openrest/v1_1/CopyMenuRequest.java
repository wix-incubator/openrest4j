package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CopyMenuRequest extends Request {
	public static final String TYPE = "copy_menu";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CopyMenuRequest() {}
    
    public CopyMenuRequest(String accessToken, String fromRestaurantId, String toRestaurantId, Boolean optimize) {
    	this.accessToken = accessToken;
    	this.fromRestaurantId = fromRestaurantId;
    	this.toRestaurantId = toRestaurantId;
    	this.optimize = optimize;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String fromRestaurantId;
    
    @JsonInclude(Include.NON_NULL)
    public String toRestaurantId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean optimize = Boolean.FALSE;
}
