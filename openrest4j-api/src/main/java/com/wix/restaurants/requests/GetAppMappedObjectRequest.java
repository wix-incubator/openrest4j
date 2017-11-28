package com.wix.restaurants.requests;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AppId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetAppMappedObjectRequest extends Request {
	public static final String TYPE = "get_app_mapped_object";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetAppMappedObjectRequest() {}
    
    public GetAppMappedObjectRequest(AppId appId, Boolean full, Set<String> fields) {
    	this.appId = appId;
    	this.full = full;
    	this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetAppMappedObjectRequest that = (GetAppMappedObjectRequest) o;

        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (full != null ? !full.equals(that.full) : that.full != null) return false;
        return fields != null ? fields.equals(that.fields) : that.fields == null;
    }

    @Override
    public int hashCode() {
        int result = appId != null ? appId.hashCode() : 0;
        result = 31 * result + (full != null ? full.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
    }

    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    /** Whether or not the "full" organization object is requested. */
    public Boolean full = Boolean.TRUE;

    /** If full=false */
    @JsonInclude(Include.NON_NULL)
    public Set<String> fields;
}
