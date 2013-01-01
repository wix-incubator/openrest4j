package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Status implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
	/** Available. */
    public static final String STATUS_AVAILABLE = "available";
    /** Unavailable. */
    public static final String STATUS_UNAVAILABLE = "unavailable";
    
    /** All known statuses. */
    public static final Set<String> ALL_STATUSES = new HashSet<String>(Arrays.asList(new String[] {
    		STATUS_AVAILABLE, STATUS_UNAVAILABLE
    }));
    
    public Status(String status, java.util.Date until, String reason, Map<String, String> comment) {
    	this.status = status;
    	this.until = ((until != null) ? until.getTime() : null);
    	this.reason = reason;
    	this.comment = comment;
    }
    
    public Status(String status, java.util.Date until) {
    	this(status, until, null, new HashMap<String, String>());
    }

    /** Default constructor for JSON deserialization. */
    public Status() {}
    
	@Override
	public Object clone() {
		return new Status(status, until(), reason,
				((comment != null) ? new HashMap<String, String>(comment) : null));
	}

    public java.util.Date until() {
        return ((until != null) ? new java.util.Date(until) : null);
    }

    public boolean available() {
        return STATUS_AVAILABLE.equals(status);
    }

    @JsonInclude(Include.NON_NULL)
    public String status;

    @JsonInclude(Include.NON_NULL)
    public Long until;
    
    /** @see DateTimeWindow.reason */
    @JsonInclude(Include.NON_NULL)
    public String reason;

    /** @see DateTimeWindow.comment */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> comment = new HashMap<String, String>();
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((until == null) ? 0 : until.hashCode());
		return result;
	}
    
	public boolean equalsIgnoreUntil(Status other) {
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Status other = (Status) obj;
		if (until == null) {
			if (other.until != null)
				return false;
		} else if (!until.equals(other.until))
			return false;
		return equalsIgnoreUntil(other);
	}
}
