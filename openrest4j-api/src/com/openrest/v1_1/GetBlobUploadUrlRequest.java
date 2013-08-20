package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBlobUploadUrlRequest extends Request {
	public static final String TYPE = "get_blob_upload_url";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBlobUploadUrlRequest() {}
    
    public GetBlobUploadUrlRequest(String accessToken, String organizationId, String itemId, String blobType, Boolean noLegacy) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.blobType = blobType;
    	this.noLegacy = noLegacy;
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
    
    /**
     * If false, the response JSON will be embedded in HTML.
     * Legacy responses will be deprecated on 2013-12-01.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean noLegacy = Boolean.FALSE;
}
