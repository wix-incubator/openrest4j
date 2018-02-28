package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.VariationDisplayTypes;

import java.io.Serializable;
import java.util.*;

/**
 * A possible modification to an item, e.g. "choice of sides" for a happy-meal
 * or "degree of cooking" for a hamburger.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Variation implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

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
        return Objects.equals(title, variation.title) &&
                Objects.equals(itemIds, variation.itemIds) &&
                Objects.equals(minNumAllowed, variation.minNumAllowed) &&
                Objects.equals(maxNumAllowed, variation.maxNumAllowed) &&
                Objects.equals(prices, variation.prices) &&
                Objects.equals(defaults, variation.defaults) &&
                Objects.equals(displayType, variation.displayType) &&
                Objects.equals(properties, variation.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, itemIds, minNumAllowed, maxNumAllowed, prices, defaults, displayType, properties);
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

    /** @see VariationDisplayTypes */
    @JsonInclude(Include.NON_DEFAULT)
    public String displayType = VariationDisplayTypes.choice;

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
