package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeleteTagRequest extends Request {
	public static final String TYPE = "delete_tag";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public DeleteTagRequest() {}
    
    public DeleteTagRequest(String accessToken, String organizationId, String tagId) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.tagId = tagId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String tagId;
}
