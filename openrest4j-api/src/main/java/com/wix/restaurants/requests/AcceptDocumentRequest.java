package com.wix.restaurants.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.DocumentId;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AcceptDocumentRequest extends Request {
	public static final String TYPE = "accept_document";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public AcceptDocumentRequest() {}
    
    public AcceptDocumentRequest(String accessToken, DocumentId documentId) {
    	this.accessToken = accessToken;
    	this.documentId = documentId;
    }
    
    @JsonInclude(Include.NON_NULL)
    public String accessToken;
    
    @JsonInclude(Include.NON_NULL)
    public DocumentId documentId;
}
