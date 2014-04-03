package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ToggleProductRequest extends Request {
	public static final String TYPE = "toggle_product";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public ToggleProductRequest() {}
    
    public ToggleProductRequest(String accessToken, String organizationId, Product product, Boolean enable) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.product = product;
    	this.enable = enable;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Product product;
    
    @JsonInclude(Include.NON_NULL)
    public Boolean enable;
}
