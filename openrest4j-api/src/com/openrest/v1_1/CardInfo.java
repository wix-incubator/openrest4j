package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
	public CardInfo(String formId, Boolean active) {
		this.formId = formId;
		this.active = active;
    }

    /** Default constructor for JSON deserialization. */
    public CardInfo() {}
    
    @Override
	public Object clone() {
    	return new CardInfo(formId, active);
	}

    /*
     * The credit card form-id (one of CreditCard.ALL_FORMS) specifying the required
     * details to clear cards of that specific network.
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String formId;
    
    /** Whether or not cards of that specific network are supported. */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public Boolean active = Boolean.TRUE;
}
