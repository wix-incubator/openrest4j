package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Menu implements Serializable {
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

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Item> items = Collections.emptyList();

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Tag> tags = Collections.emptyList();

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Category> categories = Collections.emptyList();

    private static final long serialVersionUID = 1L;
}
