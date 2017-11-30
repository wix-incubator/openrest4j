package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

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
	public Contact clone() {
		return new Contact(firstName, lastName, email, phone, fax);
	}
    
    public static Map<String, Contact> clone(Map<String, Contact> contacts) {
    	if (contacts == null) {
    		return null;
    	}
    	
    	final Map<String, Contact> cloned = new LinkedHashMap<>(contacts.size());
		for (Entry<String, Contact> entry : contacts.entrySet()) {
			final String key = entry.getKey();
			final Contact value = entry.getValue();
			cloned.put(key, (value != null) ? value.clone() : null);
		}
		return cloned;
    }

	public static List<Contact> clone(List<Contact> contacts) {
        if (contacts == null) {
            return null;
        }

        final List<Contact> cloned = new LinkedList<>();
        for (Contact contact : contacts) {
            cloned.add((contact != null) ? contact.clone() : null);
        }
        return cloned;
    }

    @JsonInclude(Include.NON_NULL)
    public String firstName;

    @JsonInclude(Include.NON_NULL)
    public String lastName;

    @JsonInclude(Include.NON_NULL)
    public String email;

    @JsonInclude(Include.NON_NULL)
    public String phone;
    
    @JsonInclude(Include.NON_NULL)
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
