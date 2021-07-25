package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LatLng implements Serializable, Cloneable {
    private static final long serialVersionUID = 1L;

	public LatLng(Double lat, Double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /** Default constructor for JSON deserialization. */
    public LatLng() {}
    
    @Override
	public LatLng clone() {
    	return new LatLng(lat, lng);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LatLng latLng = (LatLng) o;
        return Objects.equals(lat, latLng.lat) &&
                Objects.equals(lng, latLng.lng);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lat, lng);
    }

    @Override
    public String toString() {
        return "LatLng{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}';
    }

    @JsonInclude(Include.NON_NULL)
    public Double lat;

    @JsonInclude(Include.NON_NULL)
    public Double lng;

    @JsonInclude(Include.NON_NULL)
    public String latStr; // required for encryption

    @JsonInclude(Include.NON_NULL)
    public String lngStr; // required for encryption
}
