package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Location implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public Location() {}

    public Location(String id, String name, String description, Boolean defaultLocation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.defaultLocation = defaultLocation;
    }

    @Override
    public Location clone() {
        return new Location(id, name, description, defaultLocation);
    }

    public static Map<String, Location> clone(Map<String, Location> locations) {
        if (locations == null) {
            return null;
        }

        final Map<String, Location> cloned = new LinkedHashMap<>(locations.size());
        for (Map.Entry<String, Location> entry : locations.entrySet()) {
            final String key = entry.getKey();
            final Location value = entry.getValue();
            cloned.put(key, (value != null) ? value.clone() : null);
        }
        return cloned;
    }

    public static List<Location> clone(List<Location> locations) {
        if (locations == null) {
            return null;
        }

        final List<Location> cloned = new LinkedList<>();
        for (Location location : locations) {
            cloned.add((location != null) ? location.clone() : null);
        }
        return cloned;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return Objects.equals(id, location.id) &&
                Objects.equals(name, location.name) &&
                Objects.equals(description, location.description) &&
                Objects.equals(defaultLocation, location.defaultLocation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, defaultLocation);
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String id;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String name;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public String description;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public Boolean defaultLocation;
}
