package com.openrest.v1_1;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

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

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String country;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String city;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String street;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String number;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String apt;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String floor;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String entrance;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String comment;

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public LatLng latLng;
    
    /**
     * Two letter country code.
     * @see http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2
     */
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String countryCode;
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
    public String postalCode;
}
