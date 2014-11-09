package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Seo implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Seo(String title, Map<String, String> meta, String html) {
    	this.title = title;
    	this.meta = meta;
    	this.html = html;
    }
    
    /** Default constructor for JSON deserialization. */
    public Seo() {}
    
    @Override
	public Object clone() {
    	return new Seo(title,
    			((meta != null) ? new HashMap<String, String>(meta) : null),
    			html);
	}
    
    /** The HTML title. */
    @JsonInclude(Include.NON_NULL)
    public String title;
    
    /** HTML meta tags. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> meta = Collections.emptyMap();
    
    /** Marketing HTML block to embed in the web-site. */
    @JsonInclude(Include.NON_NULL)
    public String html;
}
