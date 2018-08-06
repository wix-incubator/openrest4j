package com.openrest.v1_1;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.pay.smaug.client.model.CreditCardToken;
import com.wix.restaurants.authentication.model.User;
import com.wix.restaurants.payments.CibusCard;

import java.io.Serializable;
import java.util.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class ClientInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public ClientInfo(List<User> ids, List<Contact> contacts, List<Address> addresses,
                      List<ClubMember> memberships, List<CreditCardToken> cardTokens,
                      List<CibusCard> cibus,
                      Map<String, String> properties, Map<String, String> comments) {
		this.ids = ids;
    	this.contacts = contacts;
    	this.addresses = addresses;
    	this.memberships = memberships;
        this.cardTokens = cardTokens;
        this.cibus = cibus;
    	this.properties = properties;
    	this.comments = comments;
    }
    
    /** Default constructor for JSON deserialization. */
    public ClientInfo() {}
    
    @Override
	public ClientInfo clone() {
        final List<User> clonedIds;
        if (ids != null) {
            clonedIds = new LinkedList<>();
            for (User id : ids) {
                clonedIds.add(id != null ? id.clone() : null);
            }
        } else {
            clonedIds = null;
        }


    	return new ClientInfo(
                clonedIds, Contact.clone(contacts), Address.clone(addresses),
                ClubMember.clone(memberships),
                ((cardTokens != null) ? new LinkedList<>(cardTokens) : null),
    			CibusCard.clone(cibus),
    			((properties != null) ? new LinkedHashMap<>(properties) : null),
    			((comments != null) ? new LinkedHashMap<>(comments) : null));
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClientInfo that = (ClientInfo) o;
        return Objects.equals(ids, that.ids) &&
                Objects.equals(contacts, that.contacts) &&
                Objects.equals(addresses, that.addresses) &&
                Objects.equals(memberships, that.memberships) &&
                Objects.equals(cardTokens, that.cardTokens) &&
                Objects.equals(cibus, that.cibus) &&
                Objects.equals(properties, that.properties) &&
                Objects.equals(comments, that.comments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ids, contacts, addresses, memberships, cardTokens, cibus, properties, comments);
    }

    @Override
    public String toString() {
        return "ClientInfo{" +
                "ids=" + ids +
                ", contacts=" + contacts +
                ", addresses=" + addresses +
                ", memberships=" + memberships +
                ", cardTokens=" + cardTokens +
                ", cibus=" + cibus +
                ", properties=" + properties +
                ", comments=" + comments +
                '}';
    }

    /** Saved contact details. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<User> ids = new LinkedList<>();
    
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

    /** Saved Cibus cards. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<CibusCard> cibus = new LinkedList<>();

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
