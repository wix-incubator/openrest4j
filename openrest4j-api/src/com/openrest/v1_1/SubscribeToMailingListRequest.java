package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.availability.Date;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SubscribeToMailingListRequest extends Request {
	public static final String TYPE = "subscribe";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SubscribeToMailingListRequest() {}
    
    public SubscribeToMailingListRequest(String accessToken, String organizationId, Contact contact, Address address, Date birthday) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.contact = contact;
    	this.address = address;
    	this.birthday = birthday;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Contact contact;
    
    @JsonInclude(Include.NON_NULL)
    public Address address;
    
    @JsonInclude(Include.NON_NULL)
    public Date birthday;
}
