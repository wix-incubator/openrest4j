package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Information regarding a remote user of the system.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public User(String id, String ipAddress, String fwdIpAddresses) {
        this.id = id;
        this.ipAddress = ipAddress;
        this.fwdIpAddresses = fwdIpAddresses;
    }

    /** Default constructor for JSON deserialization. */
    public User() {}

    /** The user's Facebook id. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;
    
    /** Whether the user's Facebook id is inferred (as opposed to verified). */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean idIsInferred = Boolean.FALSE;

    /**
     * The immediate client's IP address. If the real client is separated from the
     * server by a proxy server, this will return the IP address of the proxy.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String ipAddress;

    /**
     * Corresponds to the "X-Forwarded-For" HTTP header.
     * This generally contains the user agent IP address (but can be spoofed).
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String fwdIpAddresses;
}
