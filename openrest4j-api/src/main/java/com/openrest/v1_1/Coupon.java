package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;
 
@JsonIgnoreProperties(ignoreUnknown = true)
public class Coupon implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	/** Discount coupon. */
    public static final String COUPON_TYPE_DISCOUNT = "discount";
    /** M+N coupon. */
    public static final String COUPON_TYPE_M_PLUS_N = "m_plus_n";
    
    /** All known coupouns. */
    public static final Set<String> ALL_COUPON_TYPES = new HashSet<String>(
    		Arrays.asList(COUPON_TYPE_DISCOUNT, COUPON_TYPE_M_PLUS_N));
   
    public Coupon(String type, LocalizedString title, LocalizedString description,
				  Integer maxNumAllowed, Boolean othersAllowed, Map<String, String> properties) {
    	this.type = type;
    	this.title = title;
    	this.description = description;
    	this.maxNumAllowed = maxNumAllowed;
    	this.othersAllowed = othersAllowed;
    	this.properties = properties;
    }
    
	/** Default constructor for JSON deserialization. */
    public Coupon() {}
    
    @Override
	public Object clone() {
    	return new Coupon(type,
    			((title != null) ? (LocalizedString) title.clone() : null),
    			((description != null) ? (LocalizedString) description.clone()  : null),
    			maxNumAllowed, othersAllowed,
    			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
   
    /** The coupon's type. */
    @JsonInclude(Include.NON_NULL)
    public String type;
   
    /** The coupon's user-friendly short name in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;
    
    /** The coupon's user-friendly description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;
    
    /** Maximum number of times this coupon can be used in a single order. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer maxNumAllowed = Integer.MAX_VALUE;
   
    /** Whether or not other coupons can be used with this one. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean othersAllowed = Boolean.TRUE;
    
    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result
				+ ((maxNumAllowed == null) ? 0 : maxNumAllowed.hashCode());
		result = prime * result
				+ ((othersAllowed == null) ? 0 : othersAllowed.hashCode());
		result = prime * result
				+ ((properties == null) ? 0 : properties.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coupon other = (Coupon) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (maxNumAllowed == null) {
			if (other.maxNumAllowed != null)
				return false;
		} else if (!maxNumAllowed.equals(other.maxNumAllowed))
			return false;
		if (properties == null) {
			if (other.properties != null)
				return false;
		} else if (!properties.equals(other.properties))
			return false;
		if (othersAllowed == null) {
			if (other.othersAllowed != null)
				return false;
		} else if (!othersAllowed.equals(other.othersAllowed))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
}