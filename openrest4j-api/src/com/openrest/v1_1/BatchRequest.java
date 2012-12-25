package com.openrest.v1_1;

import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BatchRequest extends Request {
	public static final String TYPE = "batch";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public BatchRequest() {}
    
    public BatchRequest(List<Request> requests) {
    	this.requests = requests;
    }
    
    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
    public List<Request> requests = new ArrayList<Request>();
}
