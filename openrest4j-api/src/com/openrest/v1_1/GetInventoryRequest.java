package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetInventoryRequest extends Request {
	public static final String TYPE = "get_inventory";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetInventoryRequest() {}
    
    public GetInventoryRequest(String accessToken, String organizationId, Set<String> itemIds) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemIds = itemIds;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** Item-ids to query (null means "all"). */
    @JsonInclude(Include.NON_NULL)
    public Set<String> itemIds;
}
