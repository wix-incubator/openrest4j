package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetBlobRequest extends Request {
	public static final String TYPE = "set_blob";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetBlobRequest() {}
    
    public SetBlobRequest(String accessToken, String organizationId, String itemId, String blobType, String blobId) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.blobType = blobType;
    	this.blobId = blobId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public String itemId;

    /** One of Organization.ALL_BLOB_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String blobType;

    @JsonInclude(Include.NON_NULL)
    public String blobId;
}
