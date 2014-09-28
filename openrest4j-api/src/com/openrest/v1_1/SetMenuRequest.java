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
    
    public SetMenuRequest(String accessToken, String organizationId, Menu menu, List<BlobCopy> setBlobs) {
    	this.accessToken = accessToken;
    	this.organizationId = organizationId;
    	this.menu = menu;
    	this.setBlobs = setBlobs;
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
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<BlobCopy> setBlobs = new LinkedList<BlobCopy>();
}
