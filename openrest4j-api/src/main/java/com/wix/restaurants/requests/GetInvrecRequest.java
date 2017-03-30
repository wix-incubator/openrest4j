package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.Locale;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetInvrecRequest extends Request {
	public static final String TYPE = "get_invrec";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetInvrecRequest() {}
    
    public GetInvrecRequest(String accessToken, String invrecId, Locale locale) {
    	this.accessToken = accessToken;
    	this.invrecId = invrecId;
    	this.locale = locale;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String invrecId;
    
    /** For Invrec.html */
    @JsonInclude(Include.NON_NULL)
    public Locale locale;
}
