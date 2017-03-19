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
    	
    	final List<AcceptedDocument> cloned = new LinkedList<>();
		for (AcceptedDocument acceptedDocument : acceptedDocuments) {
			cloned.add((acceptedDocument != null) ? (AcceptedDocument) acceptedDocument.clone() : null);
		}
		return cloned;
    }

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		AcceptedDocument that = (AcceptedDocument) o;

		if (documentId != null ? !documentId.equals(that.documentId) : that.documentId != null) return false;
		return accepted != null ? accepted.equals(that.accepted) : that.accepted == null;
	}

	@Override
	public int hashCode() {
		int result = documentId != null ? documentId.hashCode() : 0;
		result = 31 * result + (accepted != null ? accepted.hashCode() : 0);
		return result;
	}

    /** Document id. */
    @JsonInclude(Include.NON_NULL)
	public DocumentId documentId;

    /** Timestamp in which the ToS was accepted. */
    @JsonInclude(Include.NON_NULL)
	public Long accepted;
}
