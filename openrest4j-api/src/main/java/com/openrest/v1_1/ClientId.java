package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class ClientId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public static final String NS_PHONE = "tel";
    public static final String NS_OPENREST = "com.openrest";
    public static final String NS_FACEBOOK = "com.facebook";
    
    public ClientId(String ns, String id, String uid, Boolean inferred) {
    	this.ns = ns;
        this.id = id;
        this.uid = uid;
        this.inferred = inferred;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientId() {}
    
    @Override
	public Object clone() {
    	return new ClientId(ns, id, uid, inferred);
	}
    
    /** The unique id's namespace. */
    @JsonInclude(Include.NON_NULL)
    public String ns;
	
    /** The unique id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The fully qualified (legacy) namespace|id. */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String uid;
    
    /** Whether the id is inferred (as opposed to verified). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inferred = Boolean.FALSE;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((inferred == null) ? 0 : inferred.hashCode());
		result = prime * result + ((ns == null) ? 0 : ns.hashCode());
		result = prime * result + ((uid == null) ? 0 : uid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClientId other = (ClientId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inferred == null) {
			if (other.inferred != null)
				return false;
		} else if (!inferred.equals(other.inferred))
			return false;
		if (ns == null) {
			if (other.ns != null)
				return false;
		} else if (!ns.equals(other.ns))
			return false;
		if (uid == null) {
			if (other.uid != null)
				return false;
		} else if (!uid.equals(other.uid))
			return false;
		return true;
	}
}
