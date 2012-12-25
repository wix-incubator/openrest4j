package com.openrest.v1_1;

import java.util.Collection;
import java.util.Date;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class QueryOrdersRequest extends Request {
	public static final String TYPE = "query_orders";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public QueryOrdersRequest() {}
    
    public QueryOrdersRequest(String accessToken, String distributorId, String chainId, Collection<String> restaurantIds, String userId,
    		String status, String ref, Long since, Long until, String query, Boolean restaurantView, String ordering, Set<String> fields,
    		Integer limit) {
    	this.accessToken = accessToken;
    	this.distributorId = distributorId;
    	this.chainId = chainId;
    	this.restaurantIds = restaurantIds;
    	this.userId = userId;
    	this.status = status;
    	this.ref = ref;
    	this.since = since;
    	this.until = until;
    	this.query = query;
    	this.restaurantView = restaurantView;
    	this.ordering = ordering;
    	this.fields = fields;
    	this.limit = limit;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String distributorId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String chainId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Collection<String> restaurantIds;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String userId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String status;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String ref;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long since;
    
    public Date since() {
    	return ((since != null) ? new Date(since.longValue()) : null);
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Long until;
    
    public Date until() {
    	return ((until != null) ? new Date(until.longValue()) : null);
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String query;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean restaurantView = Boolean.FALSE;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String ordering;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public Set<String> fields;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer limit;
}
