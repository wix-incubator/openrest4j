package com.openrest.v1_1;

import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetMenuRequest extends Request {
	public static final String TYPE = "set_menu";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public SetMenuRequest() {}
    
    public SetMenuRequest(String accessToken, String organizationId, Menu menu, List<Charge> charges, Boolean optimize) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.menu = menu;
    	this.charges = charges;
    	this.optimize = optimize;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public String organizationId;
    
    @JsonInclude(Include.NON_NULL)
    public Menu menu;
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<Charge>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean optimize = Boolean.FALSE;
}
