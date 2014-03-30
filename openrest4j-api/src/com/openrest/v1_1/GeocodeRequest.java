package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GeocodeRequest extends Request {
	public static final String TYPE = "geocode";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GeocodeRequest() {}
}
