package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlobRequest extends Request {
	public static final String TYPE = "get_blob";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBlobRequest() {}
    
    public GetBlobRequest(String organizationId, String itemId, String blobType) {
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.blobType = blobType;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String itemId;

    /** One of Organization.ALL_BLOB_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String blobType;
}
