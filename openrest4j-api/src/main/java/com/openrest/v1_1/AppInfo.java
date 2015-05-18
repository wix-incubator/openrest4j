package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;

/** Application (e.g. iPhone app) information. */
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
    public static final Set<String> ALL_APP_TYPES = new HashSet<>(Arrays.asList(new String[] {
    		APP_TYPE_CLIENT, APP_TYPE_EMPLOYEE
    }));
    
    public AppInfo(String type, String platform, String id, String version, String link, String state) {
    	this.type = type;
        this.platform = platform;
        this.id = id;
        this.version = version;
        this.link = link;
        this.state = state;
    }

    /** Default constructor for JSON deserialization. */
    public AppInfo() {}
    
    @Override
	public Object clone() {
    	return new AppInfo(type, platform, id, version, link, state);
	}
    
    public static List<AppInfo> clone(List<AppInfo> apps) {
    	if (apps == null) {
    		return null;
    	}
    	
    	final List<AppInfo> cloned = new LinkedList<>();
		for (AppInfo app : apps) {
			cloned.add((app != null) ? (AppInfo) app.clone() : null);
		}
		return cloned;
    }

    /** Application type (@see ALL_APP_TYPES) */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** Application platform (@see ALL_PLATFORMS) */
    @JsonInclude(Include.NON_NULL)
    public String platform;

    /**
     * Application id, in a platform specific format:
     * iOS platform: "bundle id"
     */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The latest application version. */
    @JsonInclude(Include.NON_NULL)
    public String version;

    /** The application's download link. */
    @JsonInclude(Include.NON_NULL)
    public String link;
    
    /** @see State#ALL_STATES */
    @JsonInclude(Include.NON_DEFAULT)
    public String state = State.STATE_OPERATIONAL;
}
