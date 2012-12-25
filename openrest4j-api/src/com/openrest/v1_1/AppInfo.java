package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

/**
 * Application (e.g. iPhone app) information.
 * @author DL
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppInfo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    /** Android platform. */
    public static final String PLATFORM_ANDROID = "android";
	/** iOS platform. */
    public static final String PLATFORM_IOS = "ios";
    
    /** All known platforms. */
    public static final Set<String> ALL_PLATFORMS = new HashSet<String>(Arrays.asList(new String[] {
    		PLATFORM_ANDROID, PLATFORM_IOS
    }));
    
    /** Client application. */
    public static final String APP_TYPE_CLIENT = "client";
	/** Employee application. */
    public static final String APP_TYPE_EMPLOYEE = "employee";
    
    /** All known application types. */
    public static final Set<String> ALL_APP_TYPES = new HashSet<String>(Arrays.asList(new String[] {
    		APP_TYPE_CLIENT, APP_TYPE_EMPLOYEE
    }));
    
    public AppInfo(String type, String platform, String id,
    		String version, String link) {
    	this.type = type;
        this.platform = platform;
        this.id = id;
        this.version = version;
        this.link = link;
    }

    /** Default constructor for JSON deserialization. */
    public AppInfo() {}
    
    @Override
	public Object clone() {
    	return new AppInfo(type, platform, id, version, link);
	}

    /** Application type (@see ALL_APP_TYPES) */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String type;
    
    /** Application platform (@see ALL_PLATFORMS) */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String platform;

    /**
     * Application id, in a platform specific format:
     * iOS platform -> "bundle id"
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;

    /** The latest application version. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String version;

    /** The application's download link. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String link;
}
