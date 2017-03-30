package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetBlobRequest extends Request {
	public static final String TYPE = "set_blob";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetBlobRequest() {}
    
    public SetBlobRequest(String accessToken, String organizationId, String itemId, String blobType,
                          String blobId, String url, String servableUrl) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.blobType = blobType;
    	this.blobId = blobId;
    	this.url = url;
    	this.servableUrl = servableUrl;
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

    /** Existing blob-id to link to. Leave null if using url or servableUrl. */
    @JsonInclude(Include.NON_NULL)
    public String blobId;

    /**
     * External url to import blob data from (can be discarded after import operation).
     * Leave null if using blobId or servableUrl.
     */
    @JsonInclude(Include.NON_NULL)
    public String url;

    /**
     * External url to use as-is in blob (must be a permanent https:// url).
     * Leave null if using blobId or url.
     */
    @JsonInclude(Include.NON_NULL)
    public String servableUrl;
}
