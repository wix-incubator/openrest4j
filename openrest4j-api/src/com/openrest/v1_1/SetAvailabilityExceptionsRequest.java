package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetAvailabilityExceptionsRequest extends Request {
	public static final String TYPE = "set_availability_exceptions";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetAvailabilityExceptionsRequest() {}
    
    public SetAvailabilityExceptionsRequest(String accessToken, String organizationId, String itemId,
    		List<DateTimeWindow> exceptions) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.itemId = itemId;
    	this.exceptions = exceptions;
    }
    
    public static SetAvailabilityExceptionsRequest withOrganization(String accessToken,
    		String organizationId, List<DateTimeWindow> exceptions) {
    	return new SetAvailabilityExceptionsRequest(accessToken, organizationId, null, exceptions);
    }
    
    public static SetAvailabilityExceptionsRequest withItem(String accessToken,
    		String itemId, List<DateTimeWindow> exceptions) {
    	return new SetAvailabilityExceptionsRequest(accessToken, null, itemId, exceptions);
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String accessToken;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String organizationId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String itemId;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<DateTimeWindow> exceptions = new ArrayList<DateTimeWindow>();
}
