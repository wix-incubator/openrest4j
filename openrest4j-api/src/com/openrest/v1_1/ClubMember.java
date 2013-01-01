package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 * Identifies a club member to the restaurant.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ClubMember implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Default constructor for JSON deserialization. */
    public ClubMember(String organizationId, String memberId, String phone, Set<String> clubIds) {
    	this.organizationId = organizationId;
    	this.memberId = memberId;
    	this.phone = phone;
    	this.clubIds = clubIds;
    	this.restaurantId = organizationId; // for backwards compatibility
    }
    
    /** Default constructor for JSON deserialization. */
    public ClubMember() {}
    
    @Override
	public Object clone() {
    	return new ClubMember(organizationId, memberId, phone,
    			((clubIds != null) ? new LinkedHashSet<String>(clubIds) : null));
	}
    
    /** The organization's id. */
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /** The restaurant's id. */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String restaurantId;
    
    /** The club member's id (e.g. number on membership card). */
    @JsonInclude(Include.NON_NULL)
    public String memberId;
    
    /** The club member's phone number. */
    @JsonInclude(Include.NON_NULL)
    public String phone;
    
    /** The internal club ids of which the client is a member of. */
    public Set<String> clubIds = new LinkedHashSet<String>();
}
