package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;

import java.io.Serializable;
import java.util.*;
import java.util.Map.Entry;

/** Information required to build an app. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AppBuildInfo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	public static final String STATE_NEW = "new";
	public static final String STATE_PUBLISHING_AT_PUBLISHER = "waiting-for-distributor-approval";
	public static final String STATE_PUBLISHING_AT_BOT = "waiting-for-build";
	public static final String STATE_PUBLISHING_AT_STORE = "bot-delivered";
	public static final String STATE_REMOVING_AT_PUBLISHER = "waiting-for-distributor-removal";
	public static final String STATE_REMOVING_AT_BOT = "pending-removal";
	public static final String STATE_OPERATIONAL = "operational";
	public static final String STATE_DEPRECATED = "deprecated";
	public static final String STATE_REMOVED = "removed";
	public static final String STATE_ERROR = "bot-error";
	
    /** All known statuses. */
    public static final Set<String> ALL_STATES = new HashSet<>(Arrays.asList(
    		STATE_NEW, STATE_PUBLISHING_AT_PUBLISHER, STATE_PUBLISHING_AT_BOT, STATE_PUBLISHING_AT_STORE,
    		STATE_REMOVING_AT_PUBLISHER, STATE_REMOVING_AT_BOT,
    		STATE_OPERATIONAL, STATE_DEPRECATED, STATE_REMOVED, STATE_ERROR));
	
    public AppBuildInfo(String id, Date created, Date modified, String distributorId, String ownerId, String type, String link,
    		AppId appId, String internalId, String filename, Locale locale, Map<Locale, String> title,
    		Map<Locale, String> description, Map<String, AppstoreInfo> storeInfos, Map<String, String> properties,
    		Map<String, Blob> blobs, String state, List<LogEntry> log) {
    	this.id = id;
    	this.created = created;
    	this.modified = modified;
    	this.distributorId = distributorId;
    	this.ownerId = ownerId;
    	this.type = type;
    	this.link = link;
    	this.appId = appId;
    	this.internalId = internalId;
    	this.filename = filename;
    	this.locale = locale;
    	this.title = title;
    	this.description = description;
    	this.storeInfos = storeInfos;
    	this.properties = properties;
    	this.blobs = blobs;
    	this.state = state;
    	this.log = log;
    }

    /** Default constructor for JSON deserialization. */
    public AppBuildInfo() {}
    
    @Override
	public Object clone() {
    	final Map<String, AppstoreInfo> clonedStoreInfos;
    	if (storeInfos != null) {
    		clonedStoreInfos = new LinkedHashMap<>(storeInfos.size());
    		for (Entry<String, AppstoreInfo> entry : storeInfos.entrySet()) {
    			clonedStoreInfos.put(entry.getKey(), (AppstoreInfo) entry.getValue().clone());
    		}
    	} else {
    		clonedStoreInfos = null;
    	}
    	
    	final Map<String, Blob> clonedBlobs;
    	if (blobs != null) {
    		clonedBlobs = new LinkedHashMap<>(blobs.size());
    		for (Entry<String, Blob> entry : blobs.entrySet()) {
    			clonedBlobs.put(entry.getKey(), (Blob) entry.getValue().clone());
    		}
    	} else {
    		clonedBlobs = null;
    	}
    	
    	final List<LogEntry> clonedLog;
    	if (log != null) {
    		clonedLog = new ArrayList<>(log.size());
    		for (LogEntry logEntry : log) {
    			clonedLog.add((LogEntry) logEntry.clone());
    		}
    	} else {
    		clonedLog = null;
    	}

    	return new AppBuildInfo(id,
				(created != null) ? (Date) created.clone() : null,
				(modified != null) ? (Date) modified.clone() : null,
				distributorId, ownerId, type, link,
    			((appId != null) ? (AppId) appId.clone() : null),
    			internalId, filename, locale,
    			((title != null) ? new HashMap<>(title) : null),
    			((description != null) ? new HashMap<>(description) : null),
    			clonedStoreInfos,
    			((properties != null) ? new HashMap<>(properties) : null),
    			clonedBlobs, state, clonedLog);
	}
    
    /** Unique id for this app build info. */
    @JsonInclude(Include.NON_NULL)
    public String id;    
    
    /** Creation timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date created;
    
    /** Last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;
    
    /** Distributor in charge of publishing this app. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;
    
    /**
     * Organization-id that "owns" the app.
     * This is usually, but not necessarily, the organization the app refers to.
     */
    @JsonInclude(Include.NON_NULL)
    public String ownerId;
    
    /** Application type (@see AppInfo.ALL_APP_TYPES) */
    @JsonInclude(Include.NON_NULL)
    public String type;
    
    /** The app's download link on the appstore. */
    @JsonInclude(Include.NON_NULL)
    public String link;
    
    /** Global app id. */
    @JsonInclude(Include.NON_NULL)
    public AppId appId;
    
    /** Internal id (e.g. SKU). */
    @JsonInclude(Include.NON_NULL)
    public String internalId;
    
    /** App filename (must be a valid Java class name, and start with an upper-case character). */
    @JsonInclude(Include.NON_NULL)
    public String filename;
    
    /** Base locale of the app. */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
    
    /** The app's build (not appstore!) title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> title = new LinkedHashMap<>();
    
    /** The app's build (not appstore!) description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> description = new LinkedHashMap<>();
    
    /** Appstore information in different locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, AppstoreInfo> storeInfos = new LinkedHashMap<>();
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    /**
     * Maps blob-types to blobs.
	 * @see BlobTypes
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new LinkedHashMap<>();
    
    /** @see #ALL_STATES */
    @JsonInclude(Include.NON_NULL)
    public String state;
    
    /** Change log. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<LogEntry> log = new LinkedList<>();
}
