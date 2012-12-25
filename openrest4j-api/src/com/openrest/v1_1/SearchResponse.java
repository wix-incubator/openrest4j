package com.openrest.v1_1;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import org.codehaus.jackson.map.annotate.JsonSerialize;

public class SearchResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public SearchResponse() {}
	
    public SearchResponse(List<SearchResult> results) {
    	this.results = results;
    }

    @JsonSerialize(include = JsonSerialize.Inclusion.NON_DEFAULT)
	public List<SearchResult> results = Collections.emptyList();
}
