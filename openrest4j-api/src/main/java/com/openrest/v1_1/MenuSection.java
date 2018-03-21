package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.conditions.Condition;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuSection implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public MenuSection(String id, LocalizedString title, LocalizedString description,
                       List<MenuSection> children, List<String> itemIds,
                       Condition displayCondition, Condition condition,
                       Map<String, String> media, Map<String, String> properties) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.children = children;
        this.itemIds = itemIds;
        this.displayCondition = displayCondition;
        this.condition = condition;
        this.media = media;
        this.properties = properties;
    }

    /** Default constructor for JSON deserialization. */
    public MenuSection() {}

    @Override
    public MenuSection clone() {
        return new MenuSection(id,
                ((title != null) ? title.clone()  : null),
                ((description != null) ? description.clone() : null),
                clone(children),
                ((itemIds != null) ? new LinkedList<>(itemIds) : null),
                ((displayCondition != null) ? displayCondition.clone() : null),
                ((condition != null) ? condition.clone() : null),
                ((media != null) ? new LinkedHashMap<>(media) : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    public static List<MenuSection> clone(List<MenuSection> sections) {
        if (sections == null) {
            return null;
        }

        final List<MenuSection> cloned = new LinkedList<>();
        for (MenuSection section : sections) {
            cloned.add((section != null) ? section.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuSection that = (MenuSection) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(description, that.description) &&
                Objects.equals(children, that.children) &&
                Objects.equals(itemIds, that.itemIds) &&
                Objects.equals(displayCondition, that.displayCondition) &&
                Objects.equals(condition, that.condition) &&
                Objects.equals(media, that.media) &&
                Objects.equals(properties, that.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, children, itemIds, displayCondition, condition, media, properties);
    }

    @Override
    public String toString() {
        return "MenuSection{" +
                "id='" + id + '\'' +
                ", title=" + title +
                ", description=" + description +
                ", children=" + children +
                ", itemIds=" + itemIds +
                ", displayCondition=" + displayCondition +
                ", condition=" + condition +
                ", media=" + media +
                ", properties=" + properties +
                '}';
    }

    /** Optional category id (if exists, must be unique per menu). */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The category's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;

    /** The category's description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString description = LocalizedString.empty;

    /** Sub sections. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<MenuSection> children = new LinkedList<>();

    /** The item-ids in this category. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<String> itemIds = new LinkedList<>();

    /** Condition to display the section to end-users, e.g you can have a secret section that only shows up in certain hours. */
    @JsonInclude(Include.NON_NULL)
    public Condition displayCondition;

    /** Condition to order from the section, e.g. you can have a section that's only available for ordering in certain hours. */
    @JsonInclude(Include.NON_NULL)
    public Condition condition;

    /**
     * Maps media-types to URLs.
     * @see BlobTypes
     */
    @JsonInclude(Include.NON_NULL)
    public Map<String, String> media = new LinkedHashMap<>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
