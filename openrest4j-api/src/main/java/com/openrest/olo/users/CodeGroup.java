package com.openrest.olo.users;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/** Group based on knowing the secret code. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeGroup extends Group {
    public static final String TYPE = "code";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CodeGroup() {}
    
    public CodeGroup(String id, Map<String, String> title, Map<String, String> description,
    		String code, String codeHash, Map<String, String> properties) {
    	super(id, title, description, properties);
    	this.code = code;
    	this.codeHash = codeHash;
    }
    
	@Override
	public Object clone() {
		return new CodeGroup(id,
			((title != null) ? new LinkedHashMap<String, String>(title) : null),
			((description != null) ? new LinkedHashMap<String, String>(description) : null),
			code, codeHash,
			((properties != null) ? new LinkedHashMap<String, String>(properties) : null));
	}
	
	/** The group's secret code. */
    @JsonInclude(Include.NON_NULL)
    public String code;
    
	/** SHA1(groupId + code), base64 encoded. */
    @JsonInclude(Include.NON_NULL)
    public String codeHash;
}