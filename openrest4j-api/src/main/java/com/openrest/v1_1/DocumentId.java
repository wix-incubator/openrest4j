package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DocumentId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public DocumentId() {}
	
    public DocumentId(String ns, String id, String version) {
    	this.ns = ns;
    	this.id = id;
    	this.version = version;
    }
    
    @Override
	public Object clone() {
    	return new DocumentId(ns, id, version);
	}
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ns == null) ? 0 : ns.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		DocumentId other = (DocumentId) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ns == null) {
			if (other.ns != null)
				return false;
		} else if (!ns.equals(other.ns))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}
    
    /** Document namespace (e.g. distributor-id). */
    @JsonInclude(Include.NON_NULL)
	public String ns;

    /** Document namespace-specific id (e.g. organization type). */
    @JsonInclude(Include.NON_NULL)
	public String id;
    
    /** Document version. */
    @JsonInclude(Include.NON_DEFAULT)
	public String version;
}
