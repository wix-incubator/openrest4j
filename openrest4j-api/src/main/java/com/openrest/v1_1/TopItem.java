package com.openrest.v1_1;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TopItem implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public TopItem(String id, Map<String, String> title, Integer price, String picture) {
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
    			((title != null) ? new HashMap<String, String>(title) : null),
    			price, picture);
	}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new HashMap<String, String>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Integer price = 0;
    
    @JsonInclude(Include.NON_NULL)
    public String picture;
}
