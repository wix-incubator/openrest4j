package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.*;
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Contact contact = (Contact) o;
		return Objects.equals(firstName, contact.firstName) &&
				Objects.equals(lastName, contact.lastName) &&
				Objects.equals(email, contact.email) &&
				Objects.equals(phone, contact.phone) &&
				Objects.equals(fax, contact.fax);
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstName, lastName, email, phone, fax);
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
}
