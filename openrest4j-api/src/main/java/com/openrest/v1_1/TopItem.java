package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopItem implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public TopItem(String id, LocalizedString title, Integer price, String picture) {
    	this.id = id;
    	this.title = title;
    	this.price = price;
    	this.picture = picture;
    }
    
    public TopItem(Item item) {
    	this(item.id, item.title, item.price, item.picture);
    }
    
    /** Default constructor for JSON deserialization. */
    public TopItem() {}
    
    @Override
	public Object clone() {
    	return new TopItem(id,
    			((title != null) ? (LocalizedString) title.clone() : null),
    			price, picture);
	}

    public static List<TopItem> clone(List<TopItem> topItems) {
        if (topItems == null) {
            return null;
        }

        final List<TopItem> cloned = new LinkedList<>();
        for (TopItem topItem : topItems) {
            cloned.add((topItem != null) ? (TopItem) topItem.clone() : null);
        }
        return cloned;
    }

    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;
    
    @JsonInclude(Include.NON_NULL)
    public String picture;
}
