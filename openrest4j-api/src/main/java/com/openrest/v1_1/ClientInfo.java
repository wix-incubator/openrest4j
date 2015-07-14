package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.creditcard.tokenizer.model.CreditCardToken;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public ClientInfo(List<ClientId> ids, List<Contact> contacts, List<Address> addresses,
                      List<ClubMember> memberships, List<CreditCardToken> cardTokens,
                      Map<String, String> properties, Map<String, String> comments) {
		this.ids = ids;
    	this.contacts = contacts;
    	this.addresses = addresses;
    	this.memberships = memberships;
        this.cardTokens = cardTokens;
    	this.properties = properties;
    	this.comments = comments;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientInfo() {}
    
    @Override
	public Object clone() {
    	return new ClientInfo(
                ClientId.clone(ids), Contact.clone(contacts), Address.clone(addresses),
                ClubMember.clone(memberships),
                ((cardTokens != null) ? new LinkedList<>(cardTokens) : null),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((comments != null) ? new LinkedHashMap<>(comments) : null));
	}
    
    /** Saved contact details. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<ClientId> ids = new LinkedList<>();
    
    /** Saved contact details. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Contact> contacts = new LinkedList<>();
    
    /** Saved addresses. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Address> addresses = new LinkedList<>();
    
    /** Saved club memberships. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<ClubMember> memberships = new LinkedList<>();

    /** Saved card tokens. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<CreditCardToken> cardTokens = new LinkedList<>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
    
    /** Maps organization-ids to free-text comments regarding the user. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> comments = new LinkedHashMap<>();
}
