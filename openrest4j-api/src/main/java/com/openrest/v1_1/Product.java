package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

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
	public Product clone() {
    	return new Product(id, param);
	}
    
    public static Set<Product> clone(Set<Product> products) {
    	if (products == null) {
    		return null;
    	}
    	
    	final Set<Product> cloned = new LinkedHashSet<>(products.size());
		for (Product product : products) {
			cloned.add((product != null) ? product.clone() : null);
		}
    	return cloned;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Product product = (Product) o;
		return Objects.equals(id, product.id) &&
				Objects.equals(param, product.param);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, param);
	}

    @JsonInclude(Include.NON_NULL)
    public String id;
    
    @JsonInclude(Include.NON_NULL)
    public String param;
}
