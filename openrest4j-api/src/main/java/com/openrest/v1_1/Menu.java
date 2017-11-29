package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public Menu(Date modified, List<Item> items, List<MenuSection> sections,
                List<com.openrest.olo.charges.Charge> chargesV2) {
    	this.modified = modified;
        this.items = items;
        this.sections = sections;
        this.chargesV2 = chargesV2;
    }

    /** Default constructor for JSON deserialization. */
    public Menu() {}
    
    @Override
	public Menu clone() {
    	return new Menu(
                (modified != null) ? (Date) modified.clone() : null,
                Item.clone(items), MenuSection.clone(sections),
                com.openrest.olo.charges.Charge.clone(chargesV2));
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (modified != null ? !modified.equals(menu.modified) : menu.modified != null) return false;
        if (items != null ? !items.equals(menu.items) : menu.items != null) return false;
        if (sections != null ? !sections.equals(menu.sections) : menu.sections != null) return false;
        return !(chargesV2 != null ? !chargesV2.equals(menu.chargesV2) : menu.chargesV2 != null);
    }

    @Override
    public int hashCode() {
        int result = modified != null ? modified.hashCode() : 0;
        result = 31 * result + (items != null ? items.hashCode() : 0);
        result = 31 * result + (sections != null ? sections.hashCode() : 0);
        result = 31 * result + (chargesV2 != null ? chargesV2.hashCode() : 0);
        return result;
    }

    /** The menu's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Date modified;

    /** All menu items. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Item> items = new LinkedList<>();
    
    /** Top-level menu sections. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<MenuSection> sections = new LinkedList<>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<com.openrest.olo.charges.Charge> chargesV2 = new LinkedList<>();
}
