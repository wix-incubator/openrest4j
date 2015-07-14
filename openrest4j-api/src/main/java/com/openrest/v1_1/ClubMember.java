package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/** Identifies a club member to the restaurant. */
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

    public static List<ClubMember> clone(List<ClubMember> clubMembers) {
        if (clubMembers == null) {
            return null;
        }

        final List<ClubMember> cloned = new LinkedList<>();
        for (ClubMember clubMember : clubMembers) {
            cloned.add((clubMember != null) ? (ClubMember) clubMember.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ClubMember that = (ClubMember) o;

        if (clubIds != null ? !clubIds.equals(that.clubIds) : that.clubIds != null) return false;
        if (memberId != null ? !memberId.equals(that.memberId) : that.memberId != null) return false;
        if (organizationId != null ? !organizationId.equals(that.organizationId) : that.organizationId != null)
            return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        if (restaurantId != null ? !restaurantId.equals(that.restaurantId) : that.restaurantId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = organizationId != null ? organizationId.hashCode() : 0;
        result = 31 * result + (restaurantId != null ? restaurantId.hashCode() : 0);
        result = 31 * result + (memberId != null ? memberId.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (clubIds != null ? clubIds.hashCode() : 0);
        return result;
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
    public Set<String> clubIds = new LinkedHashSet<>();
}
