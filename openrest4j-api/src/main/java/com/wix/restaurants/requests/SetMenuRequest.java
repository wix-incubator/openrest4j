package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Menu;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMenuRequest extends Request {
	public static final String TYPE = "set_menu";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetMenuRequest() {}
    
    public SetMenuRequest(String accessToken, String organizationId, Menu menu) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.menu = menu;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    /**
     * The menu to set. If the 'modified' field is not null, the menu will only
     * be set if the current version hasn't changed.
     */
    @JsonInclude(Include.NON_NULL)
    public Menu menu;
}
