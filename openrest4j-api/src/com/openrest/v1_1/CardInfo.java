package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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

    public static Map<String, CardInfo> clone(Map<String, CardInfo> cardInfos) {
    	if (cardInfos == null) {
    		return null;
    	}
    	
    	final Map<String, CardInfo> cloned = new LinkedHashMap<String, CardInfo>(cardInfos.size());
		for (Entry<String, CardInfo> entry : cardInfos.entrySet()) {
			final String key = entry.getKey();
			final CardInfo value = entry.getValue();
			cloned.put(key, (value != null) ? (CardInfo) value.clone() : null);
		}
		return cloned;
    }
    
    /*
     * The credit card form-id (one of CreditCard.ALL_FORMS) specifying the required
     * details to clear cards of that specific network.
     */
    @JsonInclude(Include.NON_NULL)
    public String formId;
    
    /** Whether or not cards of that specific network are supported. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean active = Boolean.TRUE;
}
