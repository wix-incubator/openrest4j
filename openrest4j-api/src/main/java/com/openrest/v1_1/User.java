package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

/** Information regarding a remote user of the system. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public static final String FACEBOOK_PREFIX = "";
    public static final String OPENREST_PREFIX = "spice|";
    public static final String PHONE_PREFIX = "tel|";
    
    public User(ClientId clientId, String ipAddress, String fwdIpAddresses) {
    	this.clientId = clientId;
        this.ipAddress = ipAddress;
        this.fwdIpAddresses = fwdIpAddresses;
    }
    
    /** Default constructor for JSON deserialization. */
    public User() {}
    
    @Override
	public User clone() {
    	return new User(
    			((clientId != null) ? clientId.clone() : null),
    			ipAddress, fwdIpAddresses);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(clientId, user.clientId) &&
                Objects.equals(ipAddress, user.ipAddress) &&
                Objects.equals(fwdIpAddresses, user.fwdIpAddresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clientId, ipAddress, fwdIpAddresses);
    }

    @Override
    public String toString() {
        return "User{" +
                "clientId=" + clientId +
                ", ipAddress='" + ipAddress + '\'' +
                ", fwdIpAddresses='" + fwdIpAddresses + '\'' +
                '}';
    }

    /** The user's id. */
    @JsonInclude(Include.NON_NULL)
    public ClientId clientId;
    
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
