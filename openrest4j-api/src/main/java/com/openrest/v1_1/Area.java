package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/** An area on a map. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Area implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
	public Area(LocalizedString title, List<LatLng> polygon) {
    	this.title = title;
    	this.polygon = polygon;
    }

    /** Default constructor for JSON deserialization. */
    public Area() {}
    
    @Override
	public Area clone() {
    	final List<LatLng> clonedPolygon;
    	if (polygon != null) {
    		clonedPolygon = new ArrayList<>(polygon.size());
    		for (LatLng latLng : polygon) {
    			clonedPolygon.add(latLng.clone());
    		}
    	} else {
    		clonedPolygon = null;
    	}
    	
    	return new Area(
    			((title != null) ? title.clone()  : null),
    			clonedPolygon);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Area area = (Area) o;
		return Objects.equals(title, area.title) &&
				Objects.equals(polygon, area.polygon);
	}

	@Override
	public int hashCode() {
		return Objects.hash(title, polygon);
	}

    /** The area's human-readable title in various locales. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString title = LocalizedString.empty;
    
    /** The area (polygon vertices). */
    @JsonInclude(Include.NON_DEFAULT)
    public List<LatLng> polygon = new LinkedList<>();
}
