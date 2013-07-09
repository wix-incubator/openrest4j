package com.openrest.v1_1;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    
    public Menu(List<Item> items, List<Tag> tags, List<Category> categories) {
        this.items = items;
        this.tags = tags;
        this.categories = categories;
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

    /** Default constructor for JSON deserialization. */
    public Menu() {}

    @JsonInclude(Include.NON_DEFAULT)
    public List<Item> items = new ArrayList<Item>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<Tag> tags = new ArrayList<Tag>();

    @JsonInclude(Include.NON_DEFAULT)
    public List<Category> categories = new ArrayList<Category>();
}
