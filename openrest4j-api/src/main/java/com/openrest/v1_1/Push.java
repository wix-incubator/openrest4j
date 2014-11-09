package com.openrest.v1_1;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown=true)
public class Push implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public Push(Integer badge, String alert, String sound, Object extra) {
		this.badge = badge;
		this.alert = alert;
		this.sound = sound;
		this.extra = extra;
	}
	
    /** Default constructor for JSON deserialization. */
	public Push() {}
	
	@JsonInclude(Include.NON_NULL)
	public Integer badge;

	@JsonInclude(Include.NON_NULL)
	public String alert;

	@JsonInclude(Include.NON_NULL)
	public String sound;

	@JsonInclude(Include.NON_NULL)
	public Object extra;
}