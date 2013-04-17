package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

    public Address(String country, String city, String street, String number,
    		String apt, String floor, String entrance, String comment, LatLng latLng,
    		String countryCode, String postalCode) {
    	this.country = country;
        this.city = city;
        this.street = street;
        this.number = number;
        this.apt = apt;
        this.floor = floor;
        this.entrance = entrance;
        this.comment = comment;
        this.latLng = latLng;
        this.countryCode = countryCode;
        this.postalCode = postalCode;
    }

    /** Default constructor for JSON deserialization. */
    public Address() {}
    
    @Override
	public Object clone() {
    	return new Address(country, city, street, number, apt, floor, entrance, comment,
    			((latLng != null) ? (LatLng) latLng.clone() : null),
    			countryCode, postalCode);
	}

    public String streetAddress(boolean useCountry) {
    	final StringBuilder builder = new StringBuilder();
    	
    	builder.append(street).append(' ').append(number);
    	builder.append(", ").append(city);
    	
    	if ((postalCode != null) && (!postalCode.isEmpty())) {
    		builder.append(" ").append(postalCode);
    	}
    	
    	if ((useCountry) && (country != null) && (!country.isEmpty())) {
    		builder.append(", ").append(country);
    	}
    	
    	return builder.toString();
    }

    @JsonInclude(Include.NON_NULL)
    public String country;
    
    @JsonInclude(Include.NON_NULL)
    public String city;

    @JsonInclude(Include.NON_NULL)
    public String street;

    @JsonInclude(Include.NON_NULL)
    public String number;

    @JsonInclude(Include.NON_NULL)
    public String apt;

    @JsonInclude(Include.NON_NULL)
    public String floor;

    @JsonInclude(Include.NON_NULL)
    public String entrance;

    @JsonInclude(Include.NON_NULL)
    public String comment;

    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;
    
    /**
     * Two letter country code.
     * @see http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     */
    @JsonInclude(Include.NON_NULL)
    public String countryCode;
    
    @JsonInclude(Include.NON_NULL)
    public String postalCode;
    
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((apt == null) ? 0 : apt.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((country == null) ? 0 : country.hashCode());
		result = prime * result
				+ ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result
				+ ((entrance == null) ? 0 : entrance.hashCode());
		result = prime * result + ((floor == null) ? 0 : floor.hashCode());
		result = prime * result + ((latLng == null) ? 0 : latLng.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result
				+ ((postalCode == null) ? 0 : postalCode.hashCode());
		result = prime * result + ((street == null) ? 0 : street.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (apt == null) {
			if (other.apt != null)
				return false;
		} else if (!apt.equals(other.apt))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (country == null) {
			if (other.country != null)
				return false;
		} else if (!country.equals(other.country))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (entrance == null) {
			if (other.entrance != null)
				return false;
		} else if (!entrance.equals(other.entrance))
			return false;
		if (floor == null) {
			if (other.floor != null)
				return false;
		} else if (!floor.equals(other.floor))
			return false;
		if (latLng == null) {
			if (other.latLng != null)
				return false;
		} else if (!latLng.equals(other.latLng))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (postalCode == null) {
			if (other.postalCode != null)
				return false;
		} else if (!postalCode.equals(other.postalCode))
			return false;
		if (street == null) {
			if (other.street != null)
				return false;
		} else if (!street.equals(other.street))
			return false;
		return true;
	}
}
