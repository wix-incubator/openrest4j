package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;
    
    public Menu(Long modified, List<Item> items, List<Category> categories, List<Charge> charges) {
    	this.modified = modified;
        this.items = items;
        this.categories = categories;
        this.charges = charges;
    }

    /** Default constructor for JSON deserialization. */
    public Menu() {}
    
    @Override
	public Object clone() {
    	final List<Item> clonedItems;
    	if (items != null) {
    		clonedItems = new ArrayList<Item>(items.size());
    		for (Item item : items) {
    			clonedItems.add((Item) item.clone());
    		}
    	} else {
    		clonedItems = null;
    	}
    	
    	final List<Category> clonedCategories;
    	if (categories != null) {
    		clonedCategories = new ArrayList<Category>(categories.size());
    		for (Category category : categories) {
    			clonedCategories.add((Category) category.clone());
    		}
    	} else {
    		clonedCategories = null;
    	}
    	
    	final List<Charge> clonedCharges;
    	if (charges != null) {
    		clonedCharges = new ArrayList<Charge>(charges.size());
    		for (Charge charge : charges) {
    			clonedCharges.add((Charge) charge.clone());
    		}
    	} else {
    		clonedCharges = null;
    	}
    	
    	final List<Tag> clonedTags;
    	if (tags != null) {
    		clonedTags = new ArrayList<Tag>(tags.size());
    		for (Tag tag : tags) {
    			clonedTags.add((Tag) tag.clone());
    		}
    	} else {
    		clonedTags = null;
    	}

    	final Menu cloned = new Menu(modified, clonedItems, clonedCategories, clonedCharges);
    	cloned.tags = clonedTags;
    	return cloned;
	}
    
    /** The menu's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;

    @JsonInclude(Include.NON_DEFAULT)
    public List<Item> items = new LinkedList<Item>();
    
    /** Scheduled for deprecation on 2014-04-01 (use Item.itemIds and Charge.itemIds) */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public List<Tag> tags = new LinkedList<Tag>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<Category> categories = new LinkedList<Category>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<Charge>();
}
