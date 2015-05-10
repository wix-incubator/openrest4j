package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.availability.Availability;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MenuSection implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    public MenuSection(String id, Map<String, String> title, Map<String, String> description,
                       List<MenuSection> children, List<String> itemIds, Availability availability,
                       Map<String, Blob> blobs, Map<String, String> properties) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.children = children;
        this.itemIds = itemIds;
        this.availability = availability;
        this.blobs = blobs;
        this.properties = properties;
    }

    /** Default constructor for JSON deserialization. */
    public MenuSection() {}

    @Override
    public Object clone() {
        return new MenuSection(id,
                ((title != null) ? new LinkedHashMap<>(title) : null),
                ((description != null) ? new LinkedHashMap<>(description) : null),
                clone(children),
                ((itemIds != null) ? new LinkedList<>(itemIds) : null),
                ((availability != null) ? (Availability) availability.clone() : null),
                ((blobs != null) ? new LinkedHashMap<>(blobs) : null),
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
    }

    public static List<MenuSection> clone(List<MenuSection> sections) {
        if (sections == null) {
            return null;
        }

        final List<MenuSection> cloned = new LinkedList<>();
        for (MenuSection section : sections) {
            cloned.add((section != null) ? (MenuSection)section.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuSection that = (MenuSection) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        if (children != null ? !children.equals(that.children) : that.children != null) return false;
        if (itemIds != null ? !itemIds.equals(that.itemIds) : that.itemIds != null) return false;
        if (availability != null ? !availability.equals(that.availability) : that.availability != null) return false;
        if (blobs != null ? !blobs.equals(that.blobs) : that.blobs != null) return false;
        return !(properties != null ? !properties.equals(that.properties) : that.properties != null);

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (children != null ? children.hashCode() : 0);
        result = 31 * result + (itemIds != null ? itemIds.hashCode() : 0);
        result = 31 * result + (availability != null ? availability.hashCode() : 0);
        result = 31 * result + (blobs != null ? blobs.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }

    /** Optional category id (if exists, must be unique per menu). */
    @JsonInclude(Include.NON_NULL)
    public String id;

    /** The category's title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> title = new LinkedHashMap<>();

    /** The category's description in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> description = new LinkedHashMap<>();

    /** Sub sections. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<MenuSection> children = new LinkedList<>();

    /** The item-ids in this category. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<String> itemIds = new LinkedList<>();

    /** Time windows in which this section is available. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability availability = new Availability();

    /**
     * Maps blob-types to blobs.
     * @see GetBlobUploadUrlRequest#blobType
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Blob> blobs = new LinkedHashMap<>();

    /**
     * Map of user-defined extended properties. Developers should use unique
     * keys, e.g. "com.googlecode.openrestext".
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();
}
