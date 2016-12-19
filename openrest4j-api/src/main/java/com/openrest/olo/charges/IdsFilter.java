package com.openrest.olo.charges;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.Inclusions;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

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
    	return new IdsFilter(Inclusions.exclude, new LinkedHashSet<String>());
    }
    
    public static IdsFilter none() {
    	return new IdsFilter(Inclusions.include, new LinkedHashSet<String>());
    }
    
    @Override
	public Object clone() {
    	return new IdsFilter(type,
    			((ids != null) ? new LinkedHashSet<>(ids) : null));
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdsFilter idsFilter = (IdsFilter) o;

        if (type != null ? !type.equals(idsFilter.type) : idsFilter.type != null) return false;
        return !(ids != null ? !ids.equals(idsFilter.ids) : idsFilter.ids != null);

    }

    @Override
    public int hashCode() {
        int result = type != null ? type.hashCode() : 0;
        result = 31 * result + (ids != null ? ids.hashCode() : 0);
        return result;
    }

    /** @see Inclusions */
    @JsonInclude(Include.NON_DEFAULT)
    public String type = Inclusions.include;

    /** The ids. */
    @JsonInclude(Include.NON_NULL)
    public Set<String> ids;
}
