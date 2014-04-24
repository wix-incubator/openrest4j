package com.openrest.v1_1;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryUsageRequest extends Request {
	public static final String TYPE = "query_usage";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryUsageRequest() {}
    
    public QueryUsageRequest(String accessToken, Set<String> organizationIds, Date since, Date until) {
    	this.accessToken = accessToken;
    	this.organizationIds = organizationIds;
    	this.since = since;
    	this.until = until;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public Set<String> organizationIds;
    
    /** Inclusive. */
    @JsonInclude(Include.NON_NULL)
    public Date since;
    
    /** Exclusive. */
    @JsonInclude(Include.NON_NULL)
    public Date until;
}
