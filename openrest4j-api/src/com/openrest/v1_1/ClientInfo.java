package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public ClientInfo(List<ClientId> ids, List<Contact> contacts, List<Address> addresses,
    		List<ClubMember> memberships, Map<String, String> properties, Map<String, String> comments) {
		this.ids = ids;
    	this.contacts = contacts;
    	this.addresses = addresses;
    	this.memberships = memberships;
    	this.properties = properties;
    	this.comments = comments;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientInfo() {}
    
    @Override
	public Object clone() {
    	final List<ClientId> clonedIds;
    	if (ids != null) {
    		clonedIds = new ArrayList<ClientId>(ids.size());
    		for (ClientId id : ids) {
    			clonedIds.add((ClientId) id.clone());
    		}
    	} else {
    		clonedIds = null;
    	}
    	
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
    	
    	return new ClientInfo(clonedIds, clonedContacts, clonedAddresses, clonedMemberships,
    			((properties != null) ? new HashMap<String, String>(properties) : null),
    			((comments != null) ? new HashMap<String, String>(comments) : null));
	}
    
    /** Saved contact details. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<ClientId> ids = new ArrayList<ClientId>();
    
    /** Saved contact details. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Contact> contacts = new ArrayList<Contact>();
    
    /** Saved addresses. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Address> addresses = new ArrayList<Address>();
    
    /** Saved club memberships. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<ClubMember> memberships = new ArrayList<ClubMember>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new HashMap<String, String>();
    
    /** Maps organization-ids to free-text comments regarding the user. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> comments = new HashMap<String, String>();
}
