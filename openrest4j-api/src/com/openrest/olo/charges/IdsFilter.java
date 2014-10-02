package com.openrest.olo.charges;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IdsFilter implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public IdsFilter() {}
    
    public IdsFilter(String type, Set<String> ids) {
        this.type = type;
        this.ids = ids;
    }
    
    public static IdsFilter any() {
    	return new IdsFilter(Inclusion.TYPE_EXCLUDE, new LinkedHashSet<String>());
    }
    
    public static IdsFilter none() {
    	return new IdsFilter(Inclusion.TYPE_INCLUDE, new LinkedHashSet<String>());
    }
    
    @Override
	public Object clone() {
    	return new IdsFilter(type,
    			((ids != null) ? new LinkedHashSet<String>(ids) : null));
	}

    @JsonInclude(Include.NON_DEFAULT)
    public String type = Inclusion.TYPE_INCLUDE;

    /** The ids. */
    @JsonInclude(Include.NON_NULL)
    public Set<String> ids;
}
