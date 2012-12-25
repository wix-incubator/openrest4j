package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contact implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
    
    public Contact(String firstName, String lastName, String email, String phone, String fax) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.fax = fax;
    }
    
    /** Default constructor for JSON deserialization. */
    public Contact() {}
    
    @Override
	public Object clone() {
		return new Contact(firstName, lastName, email, phone, fax);
	}

	@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String firstName;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String lastName;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String email;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String phone;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String fax;
    
    @Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fax == null) ? 0 : fax.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		Contact other = (Contact) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (fax == null) {
			if (other.fax != null)
				return false;
		} else if (!fax.equals(other.fax))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}
}
