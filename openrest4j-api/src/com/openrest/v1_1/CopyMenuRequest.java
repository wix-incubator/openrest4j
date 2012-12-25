package com.openrest.v1_1;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String fromRestaurantId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String toRestaurantId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean optimize = Boolean.FALSE;
}
