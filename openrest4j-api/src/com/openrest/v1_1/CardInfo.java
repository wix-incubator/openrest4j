package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CardInfo implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public static final String GATEWAY_BRAINTREE = "com.braintreegateway";
    public static final String GATEWAY_MERCURYPAY = "com.mercurypay";
    public static final String GATEWAY_PAGUELOFACIL = "com.paguelofacil";
    public static final String GATEWAY_PROPAY = "com.propay";
    public static final String GATEWAY_AUTHORIZENET = "net.authorize";
    public static final String GATEWAY_FIRSTDATA = "com.firstdata";
    public static final String GATEWAY_HEARTLAND = "com.heartlandpaymentsystems";
    public static final String GATEWAY_ZCREDIT = "il.co.zcredit";
    public static final String GATEWAY_PAYPAL = "com.paypal";
    public static final String GATEWAY_STRIPE = "com.stripe";
    public static final String GATEWAY_PAYSCAPE = "com.payscape";

    public static final Set<String> ALL_GATEWAYS = new LinkedHashSet<String>(Arrays.asList(
    		GATEWAY_BRAINTREE, GATEWAY_MERCURYPAY, GATEWAY_PAGUELOFACIL, GATEWAY_PROPAY, GATEWAY_AUTHORIZENET,
    		GATEWAY_FIRSTDATA, GATEWAY_HEARTLAND, GATEWAY_ZCREDIT, GATEWAY_PAYPAL, GATEWAY_STRIPE, GATEWAY_PAYSCAPE));
    
	public CardInfo(String formId, String gatewayId, Boolean active) {
		this.formId = formId;
		this.gatewayId = gatewayId;
		this.active = active;
    }

    /** Default constructor for JSON deserialization. */
    public CardInfo() {}
    
    @Override
	public Object clone() {
    	return new CardInfo(formId, gatewayId, active);
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
    
    /**
     * The payment gateway that should process cards of this network.
     * See CardInfo.ALL_GATEWAYS 
     */
    @JsonInclude(Include.NON_NULL)
    public String gatewayId;
    
    /** Whether or not cards of that specific network are supported. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean active = Boolean.TRUE;
}
