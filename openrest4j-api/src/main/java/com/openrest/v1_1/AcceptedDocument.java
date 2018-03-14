package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class AcceptedDocument implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public AcceptedDocument() {}
	
    public AcceptedDocument(DocumentId documentId, Long accepted) {
    	this.documentId = documentId;
    	this.accepted = accepted;
    }
    
    @Override
	public AcceptedDocument clone() {
    	return new AcceptedDocument(((documentId != null) ? (DocumentId) documentId.clone() : null), accepted);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		AcceptedDocument that = (AcceptedDocument) o;
		return Objects.equals(documentId, that.documentId) &&
				Objects.equals(accepted, that.accepted);
	}

	@Override
	public int hashCode() {
		return Objects.hash(documentId, accepted);
	}

	@Override
	public String toString() {
		return "AcceptedDocument{" +
				"documentId=" + documentId +
				", accepted=" + accepted +
				'}';
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

    /** Document id. */
    @JsonInclude(Include.NON_NULL)
	public DocumentId documentId;

    /** Timestamp in which the ToS was accepted. */
    @JsonInclude(Include.NON_NULL)
	public Long accepted;
}
