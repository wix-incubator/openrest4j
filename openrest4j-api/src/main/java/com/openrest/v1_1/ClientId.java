package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

// TODO: deprecate in favor of com.wix.restaurants.authentication.model.User
public class ClientId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public ClientId(String ns, String id) {
    	this.ns = ns;
        this.id = id;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientId() {}
    
    @Override
	public ClientId clone() {
    	return new ClientId(ns, id);
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
				Objects.equals(id, clientId.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(ns, id);
	}

    @Override
    public String toString() {
        return "ClientId{" +
                "ns='" + ns + '\'' +
                ", id='" + id + '\'' +
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
}
