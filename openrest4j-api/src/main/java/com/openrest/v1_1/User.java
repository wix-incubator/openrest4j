package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Information regarding a remote user of the system. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public static final String FACEBOOK_PREFIX = "";
    public static final String OPENREST_PREFIX = "spice|";
    public static final String PHONE_PREFIX = "tel|";
    
    public User(ClientId clientId, String id, Boolean idIsInferred, String ipAddress, String fwdIpAddresses) {
    	this.clientId = clientId;
        this.id = id;
        this.idIsInferred = idIsInferred;
        this.ipAddress = ipAddress;
        this.fwdIpAddresses = fwdIpAddresses;
    }
    
    /** Default constructor for JSON deserialization. */
    public User() {}
    
    @Override
	public Object clone() {
    	return new User(
    			((clientId != null) ? (ClientId) clientId.clone() : null),
    			id, idIsInferred, ipAddress, fwdIpAddresses);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (clientId != null ? !clientId.equals(user.clientId) : user.clientId != null) return false;
        if (fwdIpAddresses != null ? !fwdIpAddresses.equals(user.fwdIpAddresses) : user.fwdIpAddresses != null) return false;
        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (idIsInferred != null ? !idIsInferred.equals(user.idIsInferred) : user.idIsInferred != null) return false;
        if (ipAddress != null ? !ipAddress.equals(user.ipAddress) : user.ipAddress != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (idIsInferred != null ? idIsInferred.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (fwdIpAddresses != null ? fwdIpAddresses.hashCode() : 0);
        return result;
    }

    /** The user's id. */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
    /** The user's Facebook id (deprecated 2014-09-16, use clientId). */
    @Deprecated
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @Deprecated
    /** Whether the user's Facebook id is inferred, as opposed to verified (deprecated 2014-09-16, use clientId). */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean idIsInferred = Boolean.FALSE;

    /**
     * The immediate client's IP address. If the real client is separated from the
     * server by a proxy server, this will return the IP address of the proxy.
     */
    @JsonInclude(Include.NON_NULL)
    public String ipAddress;

    /**
     * Corresponds to the "X-Forwarded-For" HTTP header.
     * This generally contains the user agent IP address (but can be spoofed).
     */
    @JsonInclude(Include.NON_NULL)
    public String fwdIpAddresses;
}
