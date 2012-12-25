package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Category> categories = new ArrayList<Category>();
}
