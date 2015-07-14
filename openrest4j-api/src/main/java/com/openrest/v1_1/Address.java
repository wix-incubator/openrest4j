package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

    public Address(String formatted, String country, String city, String street, String number,
    		String apt, String floor, String entrance, String comment, LatLng latLng,
    		String countryCode, String postalCode, Map<String, String> properties) {
    	this.formatted = formatted;
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
        this.properties = properties;
    }

    /** Default constructor for JSON deserialization. */
    public Address() {}
    
    @Override
	public Object clone() {
    	return new Address(formatted, country, city, street, number, apt, floor, entrance, comment,
    			((latLng != null) ? (LatLng) latLng.clone() : null),
    			countryCode, postalCode,
                ((properties != null) ? new LinkedHashMap<>(properties) : null));
	}

    public static List<Address> clone(List<Address> addresses) {
        if (addresses == null) {
            return null;
        }

        final List<Address> cloned = new LinkedList<>();
        for (Address address : addresses) {
            cloned.add((address != null) ? (Address) address.clone() : null);
        }
        return cloned;
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
    
    /** The human-readable address of this location (the reverse geocode of the 'latLng' field). */
    @JsonInclude(Include.NON_NULL)
    public String formatted;

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
    
    /** The geocode of the 'formatted' field. */
    @JsonInclude(Include.NON_NULL)
    public LatLng latLng;
    
    /**
     * Two letter country code.
     * @see <a href="http://en.wikipedia.org/wiki/ISO_3166-1_alpha-2">ISO 3166-1 alpha-2</a>
     */
    @JsonInclude(Include.NON_NULL)
    public String countryCode;
    
    @JsonInclude(Include.NON_NULL)
    public String postalCode;

    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, String> properties = new LinkedHashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address address = (Address) o;

        if (apt != null ? !apt.equals(address.apt) : address.apt != null) return false;
        if (city != null ? !city.equals(address.city) : address.city != null) return false;
        if (comment != null ? !comment.equals(address.comment) : address.comment != null) return false;
        if (country != null ? !country.equals(address.country) : address.country != null) return false;
        if (countryCode != null ? !countryCode.equals(address.countryCode) : address.countryCode != null) return false;
        if (entrance != null ? !entrance.equals(address.entrance) : address.entrance != null) return false;
        if (floor != null ? !floor.equals(address.floor) : address.floor != null) return false;
        if (formatted != null ? !formatted.equals(address.formatted) : address.formatted != null) return false;
        if (latLng != null ? !latLng.equals(address.latLng) : address.latLng != null) return false;
        if (number != null ? !number.equals(address.number) : address.number != null) return false;
        if (postalCode != null ? !postalCode.equals(address.postalCode) : address.postalCode != null) return false;
        if (properties != null ? !properties.equals(address.properties) : address.properties != null) return false;
        if (street != null ? !street.equals(address.street) : address.street != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = formatted != null ? formatted.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (apt != null ? apt.hashCode() : 0);
        result = 31 * result + (floor != null ? floor.hashCode() : 0);
        result = 31 * result + (entrance != null ? entrance.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        result = 31 * result + (latLng != null ? latLng.hashCode() : 0);
        result = 31 * result + (countryCode != null ? countryCode.hashCode() : 0);
        result = 31 * result + (postalCode != null ? postalCode.hashCode() : 0);
        result = 31 * result + (properties != null ? properties.hashCode() : 0);
        return result;
    }
}
