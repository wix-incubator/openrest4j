package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String title;
    
    /** HTML meta tags. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> meta = Collections.emptyMap();
    
    /** Marketing HTML block to embed in the web-site. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String html;
}
