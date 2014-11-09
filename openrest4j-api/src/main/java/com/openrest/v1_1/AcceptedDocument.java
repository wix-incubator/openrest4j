package com.openrest.v1_1;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class AcceptedDocument implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public AcceptedDocument() {}
	
    public AcceptedDocument(DocumentId documentId, Long accepted) {
    	this.documentId = documentId;
    	this.accepted = accepted;
    }
    
    @Override
	public Object clone() {
    	return new AcceptedDocument(((documentId != null) ? (DocumentId) documentId.clone() : null), accepted);
	}
    
    public static List<AcceptedDocument> clone(List<AcceptedDocument> acceptedDocuments) {
    	if (acceptedDocuments == null) {
    		return null;
    	}
    	
    	final List<AcceptedDocument> cloned = new LinkedList<AcceptedDocument>();
		for (AcceptedDocument acceptedDocument : acceptedDocuments) {
			cloned.add((acceptedDocument != null) ? (AcceptedDocument) acceptedDocument.clone() : null);
		}
		return cloned;
    }
    
    /** Document id. */
    @JsonInclude(Include.NON_NULL)
	public DocumentId documentId;

    /** Timestamp in which the ToS was accepted. */
    @JsonInclude(Include.NON_NULL)
	public Long accepted;
}
