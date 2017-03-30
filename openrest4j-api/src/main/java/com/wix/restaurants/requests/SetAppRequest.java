package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.AppBuildInfo;
import com.openrest.v1_1.BlobCopy;

import java.util.LinkedList;
import java.util.List;

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
    public List<BlobCopy> setBlobs = new LinkedList<>();
    
    @JsonInclude(Include.NON_NULL)
    public String comment;
}
