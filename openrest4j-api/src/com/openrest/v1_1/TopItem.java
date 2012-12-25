package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String id;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> title = Collections.emptyMap();
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Integer price = 0;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String picture;
}
