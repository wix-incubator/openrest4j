package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetCategoriesRequest extends Request {
	public static final String TYPE = "set_categories";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetCategoriesRequest() {}
    
    public SetCategoriesRequest(String accessToken, String organizationId, List<Category> categories) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.categories = categories;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Category> categories = new ArrayList<Category>();
}
