package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetFeaturesRequest extends Request {
	public static final String TYPE = "get_features";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetFeaturesRequest() {}
}
