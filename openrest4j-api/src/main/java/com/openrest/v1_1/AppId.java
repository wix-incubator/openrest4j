package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/** Application (e.g. iPhone app) information. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppId implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    /** Mobile app (Android). */
    public static final String PLATFORM_ANDROID = "android";
	/** Mobile app (iOS). */
    public static final String PLATFORM_IOS = "ios";
	/** Web platform. */
    public static final String PLATFORM_WEB = "web";
	/** Mobileweb platform. */
    public static final String PLATFORM_MOBILEWEB = "mobileweb";
	/** Facebook platform. */
    public static final String PLATFORM_FACEBOOK = "facebook";
    /** Call center. */
    public static final String PLATFORM_CALLCENTER = "callcenter";
    /** Kiosk (Android). */
    public static final String PLATFORM_KIOSK_ANDROID = "kiosk.android";
    /** Kiosk (iOS). */
    public static final String PLATFORM_KIOSK_IOS = "kiosk.ios";

    /** All known platforms. */
    public static final Set<String> ALL_PLATFORMS = new HashSet<>(Arrays.asList(
    		PLATFORM_ANDROID, PLATFORM_IOS, PLATFORM_WEB, PLATFORM_MOBILEWEB, PLATFORM_FACEBOOK,
            PLATFORM_CALLCENTER, PLATFORM_KIOSK_ANDROID, PLATFORM_KIOSK_IOS
    ));
    
	/** Namespace used with aliases (id = alias, version = meaningless). */
    public static final String NS_OPENREST = "com.openrest";
    
	/** Namespace used with Wix.com sites (id = site-id, version = meaningless). */
    public static final String NS_WIX = "com.wix";
    
    public AppId(String platform, String id, String version) {
        this.platform = platform;
        this.id = id;
        this.version = version;
    }

    /** Default constructor for JSON deserialization. */
    public AppId() {}
    
    @Override
	public Object clone() {
    	return new AppId(platform, id, version);
	}

    @Override
    public String toString() {
        return "AppId [platform=" + platform + ", id=" + id + ", version=" + version + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AppId appId = (AppId) o;

        if (platform != null ? !platform.equals(appId.platform) : appId.platform != null) return false;
        if (id != null ? !id.equals(appId.id) : appId.id != null) return false;
        return !(version != null ? !version.equals(appId.version) : appId.version != null);

    }

    @Override
    public int hashCode() {
        int result = platform != null ? platform.hashCode() : 0;
        result = 31 * result + (id != null ? id.hashCode() : 0);
        result = 31 * result + (version != null ? version.hashCode() : 0);
        return result;
    }

    /** Application platform (@see ALL_PLATFORMS) */
    @JsonInclude(Include.NON_NULL)
    public String platform;

    /**
     * Application id, in a platform specific format:
     * iOS platform: "bundle id"
     */
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    /** The application's version. */
    @JsonInclude(Include.NON_NULL)
    public String version;
}
