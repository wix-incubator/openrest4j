package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public Menu(Long modified, List<Item> items, List<MenuSection> sections, List<Category> categories,
                List<com.openrest.olo.charges.Charge> chargesV2, List<Charge> charges) {
    	this.modified = modified;
        this.items = items;
        this.sections = sections;
        this.categories = categories;
        this.chargesV2 = chargesV2;
        this.charges = charges;
    }

    /** Default constructor for JSON deserialization. */
    public Menu() {}
    
    @Override
	public Object clone() {
    	final Menu cloned = new Menu(modified, Item.clone(items), MenuSection.clone(sections),
                Category.clone(categories), com.openrest.olo.charges.Charge.clone(chargesV2), Charge.clone(charges));
    	cloned.tags = Tag.clone(tags);
    	return cloned;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (modified != null ? !modified.equals(menu.modified) : menu.modified != null) return false;
        if (items != null ? !items.equals(menu.items) : menu.items != null) return false;
        if (tags != null ? !tags.equals(menu.tags) : menu.tags != null) return false;
        if (sections != null ? !sections.equals(menu.sections) : menu.sections != null) return false;
        if (categories != null ? !categories.equals(menu.categories) : menu.categories != null) return false;
        if (chargesV2 != null ? !chargesV2.equals(menu.chargesV2) : menu.chargesV2 != null) return false;
        return !(charges != null ? !charges.equals(menu.charges) : menu.charges != null);
    }

    @Override
    public int hashCode() {
        int result = modified != null ? modified.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (tags != null ? tags.hashCode() : 0);
        result = 31 * result + (sections != null ? sections.hashCode() : 0);
        result = 31 * result + (categories != null ? categories.hashCode() : 0);
        result = 31 * result + (chargesV2 != null ? chargesV2.hashCode() : 0);
        result = 31 * result + (charges != null ? charges.hashCode() : 0);
        return result;
    }

    /** The menu's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;

    /** All menu items. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Item> items = new LinkedList<>();
    
    /** Scheduled for deprecation on 2014-04-01 (use Item.itemIds and Charge.itemIds) */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public List<Tag> tags = new LinkedList<>();

    /** Top-level menu sections. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<MenuSection> sections = new LinkedList<>();

    /**
     * Menu sections v1.
     * Scheduled for deprecation on 2015-08-01 (use sections)
     */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Category> categories = new LinkedList<>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<com.openrest.olo.charges.Charge> chargesV2 = new LinkedList<>();
    
    /**
     * Charges v1.
     * Scheduled for deprecation on 2015-04-01 (use chargesV2). 
     */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<>();
}
