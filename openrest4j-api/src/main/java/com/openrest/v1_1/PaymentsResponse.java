package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.payments.CreditcardPayment;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

public class PaymentsResponse implements Serializable {
	private static final long serialVersionUID = 1L;
	
    /** Default constructor for JSON deserialization. */
	public PaymentsResponse() {}
	
    public PaymentsResponse(List<CreditcardPayment> results) {
    	this.results = results;
    }

    @JsonInclude(Include.NON_DEFAULT)
	public List<CreditcardPayment> results = new LinkedList<>();
}
