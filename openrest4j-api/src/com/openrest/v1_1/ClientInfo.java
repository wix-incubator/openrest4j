package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfo implements Serializable, Cloneable {
	public ClientInfo(List<Contact> contacts, List<Address> addresses,
    		List<ClubMember> memberships, Map<String, String> properties) {
    	this.contacts = contacts;
    	this.addresses = addresses;
    	this.memberships = memberships;
    	this.properties = properties;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientInfo() {}
    
    @Override
	public Object clone() {
    	final List<Contact> clonedContacts;
    	if (contacts != null) {
    		clonedContacts = new ArrayList<Contact>(contacts.size());
    		for (Contact contact : contacts) {
    			clonedContacts.add((Contact) contact.clone());
    		}
    	} else {
    		clonedContacts = null;
    	}
    	
    	final List<Address> clonedAddresses;
    	if (addresses != null) {
    		clonedAddresses = new ArrayList<Address>(addresses.size());
    		for (Address address : addresses) {
    			clonedAddresses.add((Address) address.clone());
    		}
    	} else {
    		clonedAddresses = null;
    	}
    	
    	final List<ClubMember> clonedMemberships;
    	if (memberships != null) {
    		clonedMemberships = new ArrayList<ClubMember>(memberships.size());
    		for (ClubMember membership : memberships) {
    			clonedMemberships.add((ClubMember) membership.clone());
    		}
    	} else {
    		clonedMemberships = null;
    	}
    	
    	return new ClientInfo(clonedContacts, clonedAddresses, clonedMemberships,
    			((properties != null) ? new HashMap<String, String>(properties) : null));
	}
    
    /** Saved contact details. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Contact> contacts = Collections.emptyList();
    
    /** Saved addresses. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Address> addresses = Collections.emptyList();
    
    /** Saved club memberships. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<ClubMember> memberships = Collections.emptyList();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Map<String, String> properties = Collections.emptyMap();
    
    private static final long serialVersionUID = 1L;
}
