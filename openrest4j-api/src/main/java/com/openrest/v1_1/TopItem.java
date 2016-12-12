package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopItem implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public TopItem(String id, Map<Locale, String> title, Integer price, String picture) {
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
    			((title != null) ? new LinkedHashMap<>(title) : null),
    			price, picture);
	}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<Locale, String> title = new LinkedHashMap<>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;
    
    @JsonInclude(Include.NON_NULL)
    public String picture;
}
