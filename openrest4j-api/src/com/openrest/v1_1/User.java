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
    
    public User(String id, Boolean idIsInferred, String ipAddress, String fwdIpAddresses) {
        this.id = id;
        this.idIsInferred = idIsInferred;
        this.ipAddress = ipAddress;
        this.fwdIpAddresses = fwdIpAddresses;
    }
    
    public User(String id, String ipAddress, String fwdIpAddresses) {
    	this(id, Boolean.FALSE, ipAddress, fwdIpAddresses);
    }

    /** Default constructor for JSON deserialization. */
    public User() {}
    
    @Override
	public Object clone() {
    	return new User(id, ipAddress, fwdIpAddresses);
	}

    /** The user's Facebook id. */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** Whether the user's Facebook id is inferred (as opposed to verified). */
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
