package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Menu(Long modified, List<Item> items, List<Tag> tags, List<Category> categories, List<Charge> charges) {
    	this.modified = modified;
        this.items = items;
        this.tags = tags;
        this.categories = categories;
        this.charges = charges;
    }

    public static Menu fromCategories(List<Category> categories) {
        final Menu menu = new Menu();
        menu.categories = categories;
        return menu;
    }

    public static Menu fromItems(List<Item> items) {
        final Menu menu = new Menu();
        menu.items = items;
        return menu;
    }

    public static Menu fromTags(List<Tag> tags) {
        final Menu menu = new Menu();
        menu.tags = tags;
        return menu;
    }
    
    public static Menu fromCharges(List<Charge> charges) {
        final Menu menu = new Menu();
        menu.charges = charges;
        return menu;
    }

    /** Default constructor for JSON deserialization. */
    public Menu() {}
    
    /** The menu's last modification timestamp. */
    @JsonInclude(Include.NON_NULL)
    public Long modified;

    @JsonInclude(Include.NON_DEFAULT)
    public List<Item> items = new LinkedList<Item>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<Tag> tags = new LinkedList<Tag>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<Category> categories = new LinkedList<Category>();
    
    @JsonInclude(Include.NON_DEFAULT)
    public List<Charge> charges = new LinkedList<Charge>();
}
