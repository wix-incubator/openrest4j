package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class ClientId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public ClientId(String ns, String id, String uid, Boolean inferred) {
    	this.ns = ns;
        this.id = id;
        this.uid = uid;
        this.inferred = inferred;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientId() {}
    
    @Override
	public ClientId clone() {
    	return new ClientId(ns, id, uid, inferred);
	}


	public static List<ClientId> clone(List<ClientId> clientIds) {
        if (clientIds == null) {
            return null;
        }

        final List<ClientId> cloned = new LinkedList<>();
        for (ClientId clientId : clientIds) {
            cloned.add((clientId != null) ? clientId.clone() : null);
        }
        return cloned;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ClientId clientId = (ClientId) o;
		return Objects.equals(ns, clientId.ns) &&
				Objects.equals(id, clientId.id) &&
				Objects.equals(uid, clientId.uid) &&
				Objects.equals(inferred, clientId.inferred);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ns, id, uid, inferred);
	}

    @Override
    public String toString() {
        return "ClientId{" +
                "ns='" + ns + '\'' +
                ", id='" + id + '\'' +
                ", uid='" + uid + '\'' +
                ", inferred=" + inferred +
                '}';
    }

    /**
     * The unique id's namespace.
     * @see com.wix.restaurants.ClientNamespaces
     */
    @JsonInclude(Include.NON_NULL)
    public String ns;

    /**
     * The unique id (namespace-specific).
     * @see com.wix.restaurants.ClientNamespaces
     */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The fully qualified (legacy) namespace|id. */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String uid;
    
    /** Whether the id is inferred (as opposed to verified). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean inferred = Boolean.FALSE;
}
