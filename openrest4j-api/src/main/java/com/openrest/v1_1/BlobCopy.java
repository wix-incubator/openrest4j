package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BlobCopy implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public BlobCopy(String organizationId, String itemId, String sectionId, String blobType,
                    String blobId,
                    String url,
                    String servableUrl) {
    	this.organizationId = organizationId;
    	this.itemId = itemId;
        this.sectionId = sectionId;
    	this.blobType = blobType;
    	this.blobId = blobId;
    	this.url = url;
        this.servableUrl = servableUrl;
    }

    /** Default constructor for JSON deserialization. */
    public BlobCopy() {}

    @Override
	public Object clone() {
    	return new BlobCopy(organizationId, itemId, sectionId, blobType, blobId, url, servableUrl);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BlobCopy blobCopy = (BlobCopy) o;

        if (organizationId != null ? !organizationId.equals(blobCopy.organizationId) : blobCopy.organizationId != null) return false;
        if (itemId != null ? !itemId.equals(blobCopy.itemId) : blobCopy.itemId != null) return false;
        if (sectionId != null ? !sectionId.equals(blobCopy.sectionId) : blobCopy.sectionId != null) return false;
        if (blobType != null ? !blobType.equals(blobCopy.blobType) : blobCopy.blobType != null) return false;
        if (blobId != null ? !blobId.equals(blobCopy.blobId) : blobCopy.blobId != null) return false;
        if (url != null ? !url.equals(blobCopy.url) : blobCopy.url != null) return false;
        return servableUrl != null ? servableUrl.equals(blobCopy.servableUrl) : blobCopy.servableUrl == null;
    }

    @Override
    public int hashCode() {
        int result = organizationId != null ? organizationId.hashCode() : 0;
        result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
        result = 31 * result + (sectionId != null ? sectionId.hashCode() : 0);
        result = 31 * result + (blobType != null ? blobType.hashCode() : 0);
        result = 31 * result + (blobId != null ? blobId.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (servableUrl != null ? servableUrl.hashCode() : 0);
        return result;
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
