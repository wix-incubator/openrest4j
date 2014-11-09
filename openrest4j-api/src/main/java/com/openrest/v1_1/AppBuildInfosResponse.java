package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AppBuildInfosResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public AppBuildInfosResponse() {}
	
    public AppBuildInfosResponse(List<AppBuildInfo> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<AppBuildInfo> results = new LinkedList<AppBuildInfo>();
}
