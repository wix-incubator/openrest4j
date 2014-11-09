package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class HtmlContent implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public HtmlContent() {}
	
    public HtmlContent(String subject, String body) {
    	this.subject = subject;
    	this.body = body;
    }
    
    @Override
	public Object clone() {
    	return new HtmlContent(subject, body);
	}

    @JsonInclude(Include.NON_NULL)
	public String subject;
    
    @JsonInclude(Include.NON_NULL)
	public String body;
}
