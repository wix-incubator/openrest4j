package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** AppStore application publisher .*/
@JsonIgnoreProperties(ignoreUnknown = true)
public class Certificate implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Certificate(String url, String alias, String password) {
        this.url = url;
        this.alias = alias;
        this.password = password;
    }

	/** Default constructor for JSON deserialization. */
    public Certificate() {}
    
    @Override
	public Object clone() {
    	return new Certificate(url, alias, password);
	}
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alias == null) ? 0 : alias.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Certificate other = (Certificate) obj;
		if (alias == null) {
			if (other.alias != null)
				return false;
		} else if (!alias.equals(other.alias))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

    /** URL to key-store (JKS format). */
    @JsonInclude(Include.NON_NULL)
    public String url;

    /** Certificate alias. */
    @JsonInclude(Include.NON_NULL)
    public String alias;
    
    /** Key-store password. */
    @JsonInclude(Include.NON_NULL)
    public String password;
}
