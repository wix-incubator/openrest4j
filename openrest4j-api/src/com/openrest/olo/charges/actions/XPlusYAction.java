package com.openrest.olo.charges.actions;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.charges.ItemsFilter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class XPlusYAction extends Action {
    public static final String TYPE = "x_plus_y";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public XPlusYAction() {}
    
    public XPlusYAction(ItemsFilter buyItems, Integer buyCount, ItemsFilter getItems, Integer getCount,
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
			((buyItems != null) ? (ItemsFilter) buyItems.clone() : null),
			buyCount,
			((getItems != null) ? (ItemsFilter) getItems.clone() : null),
			getCount,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
    @JsonInclude(Include.NON_NULL)
    public ItemsFilter buyItems;
    
    @JsonInclude(Include.NON_NULL)
    public Integer buyCount;
    
    @JsonInclude(Include.NON_NULL)
    public ItemsFilter getItems;
    
    @JsonInclude(Include.NON_NULL)
    public Integer getCount;
}