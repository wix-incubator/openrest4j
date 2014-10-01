package com.openrest.olo.charges.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.IdsFilter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XPlusYAction extends Action {
    public static final String TYPE = "x_plus_y";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public XPlusYAction() {}
    
    public XPlusYAction(IdsFilter buyItems, Integer buyCount, IdsFilter getItems, Integer getCount,
    		Map<String, String> properties) {
    	super(properties);
    	this.buyItems = buyItems;
    	this.buyCount = buyCount;
    	this.getItems = getItems;
    	this.getCount = getCount;
    }
    
	@Override
	public Object clone() {
		return new XPlusYAction(
			((buyItems != null) ? (IdsFilter) buyItems.clone() : null),
			buyCount,
			((getItems != null) ? (IdsFilter) getItems.clone() : null),
			getCount,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public IdsFilter buyItems;
    
    @JsonInclude(Include.NON_NULL)
    public Integer buyCount;
    
    @JsonInclude(Include.NON_NULL)
    public IdsFilter getItems;
    
    @JsonInclude(Include.NON_NULL)
    public Integer getCount;
}