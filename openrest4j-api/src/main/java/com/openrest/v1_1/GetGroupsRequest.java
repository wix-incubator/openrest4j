package com.openrest.v1_1;

import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetGroupsRequest extends Request {
	public static final String TYPE = "get_groups";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetGroupsRequest() {}
    
    public GetGroupsRequest(String accessToken, String viewMode, Set<String> groupIds, Set<String> codes) {
    	this.accessToken = accessToken;
    	this.viewMode = viewMode;
    	this.groupIds = groupIds;
    	this.codes = codes;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    /** @see Group.ALL_GROUP_VIEW_MODES */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> groupIds;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> codes = new LinkedHashSet<String>();
}
