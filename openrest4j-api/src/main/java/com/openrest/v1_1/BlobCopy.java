package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlobCopy implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public BlobCopy(String organizationId, String itemId, String sectionId, String blobType, String blobId, String url) {
    	this.organizationId = organizationId;
    	this.itemId = itemId;
        this.sectionId = sectionId;
    	this.blobType = blobType;
    	this.blobId = blobId;
    	this.url = url;
    }

    /** Default constructor for JSON deserialization. */
    public BlobCopy() {}

    @Override
	public Object clone() {
    	return new BlobCopy(organizationId, itemId, sectionId, blobType, blobId, url);
	}

    /** Organization-id to copy to. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    /** Item-id to copy to. Leave null if copying to organization itself, or if using sectionId. */
    @JsonInclude(Include.NON_NULL)
    public String itemId;

    /** Section-id to copy to. Leave null if copying to organization itself, or if using itemId. */
    @JsonInclude(Include.NON_NULL)
    public String sectionId;

    /** One of Organization.ALL_BLOB_TYPES */
    @JsonInclude(Include.NON_NULL)
    public String blobType;

    /** Existing blob-id to link to. Leave null if using url. */
    @JsonInclude(Include.NON_NULL)
    public String blobId;
    
    /** External url to retrieve blob data from. Leave null if using blobId. */
    @JsonInclude(Include.NON_NULL)
    public String url;
}
