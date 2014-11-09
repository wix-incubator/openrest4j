package com.openrest.v1_1;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetAppRequest extends Request {
    public static final String TYPE = "set_app";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetAppRequest() {}
    
    public SetAppRequest(String accessToken, AppBuildInfo appBuildInfo, List<BlobCopy> setBlobs, String comment) {
    	this.accessToken = accessToken;
    	this.appBuildInfo = appBuildInfo;
    	this.setBlobs = setBlobs;
    	this.comment = comment;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public AppBuildInfo appBuildInfo;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<BlobCopy> setBlobs = new LinkedList<BlobCopy>();
    
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
