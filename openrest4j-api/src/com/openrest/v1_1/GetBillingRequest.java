package com.openrest.v1_1;

import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetBillingRequest extends Request {
	public static final String TYPE = "get_billing";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetBillingRequest() {}
    
    public GetBillingRequest(String accessToken, String organizationId, Integer year, Integer month, Set<String> fields) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.year = year;
    	this.month = month;
    	this.fields = fields;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer year;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public Integer month;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
	public Set<String> fields;
}
