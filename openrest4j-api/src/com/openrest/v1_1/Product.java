package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
	public Product(String id, String param) {
        this.id = id;
        this.param = param;
    }

    /** Default constructor for JSON deserialization. */
    public Product() {}
    
    @Override
	public Object clone() {
    	return new Product(id, param);
	}
    
    public static Set<Product> clone(Set<Product> products) {
    	if (products == null) {
    		return null;
    	}
    	
    	final Set<Product> cloned = new LinkedHashSet<Product>(products.size());
		for (Product product : products) {
			cloned.add((product != null) ? (Product) product.clone() : null);
		}
    	return cloned;
    }
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((param == null) ? 0 : param.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (param == null) {
			if (other.param != null)
				return false;
		} else if (!param.equals(other.param))
			return false;
		return true;
	}
    
    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_NULL)
    public String param;
}
