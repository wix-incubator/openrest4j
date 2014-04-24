package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class UsageResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public UsageResponse() {}
	
    public UsageResponse(Map<String, List<Usage>> usages) {
    	this.usages = usages;
    }

    /** Maps organization id to list of usages. */
    @JsonInclude(Include.NON_DEFAULT)
	public Map<String, List<Usage>> usages = new LinkedHashMap<String, List<Usage>>();
}
