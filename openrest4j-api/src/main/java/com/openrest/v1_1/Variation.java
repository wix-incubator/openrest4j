package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;

/**
 * A possible modification to an item, e.g. "choice of sides" for a happy-meal
 * or "degree of cooking" for a hamburger.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variation implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public static final String VARIATION_DISPLAY_TYPE_DIFF = "diff";
    public static final String VARIATION_DISPLAY_TYPE_CHOICE = "choice";
    /**
     * Variations that are not displayed to the customer, just to the restaurant.
     * Similar to a hidden field in an HTML form.
     */
    public static final String VARIATION_DISPLAY_TYPE_HIDDEN = "hidden";
    
    /** All known variation display types. */
    public static final Set<String> ALL_VARIATION_DISPLAY_TYPES = new HashSet<>(
    		Arrays.asList(VARIATION_DISPLAY_TYPE_DIFF, VARIATION_DISPLAY_TYPE_CHOICE, VARIATION_DISPLAY_TYPE_HIDDEN));

    public Variation(LocalizedString title, List<String> itemIds, Integer minNumAllowed,
                     Integer maxNumAllowed, Map<String, Integer> prices, Set<String> defaults, String displayType,
                     Map<String, String> properties) {
        this.title = title;
        this.itemIds = itemIds;
        this.minNumAllowed = minNumAllowed;
        this.maxNumAllowed = maxNumAllowed;
        this.prices = prices;
        this.defaults = defaults;
        this.displayType = displayType;
        this.properties = properties;
    }

    /** Default constructor for JSON deserialization. */
    public Variation() {}
    
    @Override
	public Variation clone() {
    	return new Variation(
    			((title != null) ? title.clone() : null),
    			((itemIds != null) ? new LinkedList<>(itemIds) : null),
    			minNumAllowed, maxNumAllowed,
    			((prices != null) ? new LinkedHashMap<>(prices) : null),
    			((defaults != null) ? new LinkedHashSet<>(defaults) : null),
    			displayType,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
    
    public static List<Variation> clone(List<Variation> variations) {
    	if (variations == null) {
    		return null;
    	}
    	
    	final List<Variation> cloned = new LinkedList<>();
		for (Variation variation : variations) {
			cloned.add((variation != null) ? variation.clone() : null);
		}
		return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Variation variation = (Variation) o;

        if (title != null ? !title.equals(variation.title) : variation.title != null) return false;
        if (itemIds != null ? !itemIds.equals(variation.itemIds) : variation.itemIds != null) return false;
        if (minNumAllowed != null ? !minNumAllowed.equals(variation.minNumAllowed) : variation.minNumAllowed != null) return false;
        if (maxNumAllowed != null ? !maxNumAllowed.equals(variation.maxNumAllowed) : variation.maxNumAllowed != null) return false;
        if (prices != null ? !prices.equals(variation.prices) : variation.prices != null) return false;
        if (defaults != null ? !defaults.equals(variation.defaults) : variation.defaults != null) return false;
        if (displayType != null ? !displayType.equals(variation.displayType) : variation.displayType != null) return false;
        return properties != null ? properties.equals(variation.properties) : variation.properties == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (itemIds != null ? itemIds.hashCode() : 0);
        result = 31 * result + (minNumAllowed != null ? minNumAllowed.hashCode() : 0);
        result = 31 * result + (maxNumAllowed != null ? maxNumAllowed.hashCode() : 0);
        result = 31 * result + (prices != null ? prices.hashCode() : 0);
        result = 31 * result + (defaults != null ? defaults.hashCode() : 0);
        result = 31 * result + (displayType != null ? displayType.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** The variations's name in various locales, e.g. "sides", "degree of cooking". */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** The set's name, e.g. "drink", "sides". */
    @JsonInclude(Include.NON_NULL)
    public List<String> itemIds = new LinkedList<>();
    
    /** Minimum number of items to select. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer minNumAllowed = 0;

    /** Maximum number of items to select. */
    @JsonInclude(Include.NON_DEFAULT)
    public Integer maxNumAllowed = Integer.MAX_VALUE;

    /** Items' base prices. Non-referenced items are free by default. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Integer> prices = new LinkedHashMap<>();

    /** Default selected item ids. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> defaults = new LinkedHashSet<>();

    /** Display type for human-readable printing. */
    @JsonInclude(Include.NON_DEFAULT)
    public String displayType = VARIATION_DISPLAY_TYPE_CHOICE;

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
