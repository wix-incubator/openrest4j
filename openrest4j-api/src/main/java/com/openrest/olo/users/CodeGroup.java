package com.openrest.olo.users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wix.restaurants.i18n.LocalizedString;

import java.util.LinkedHashMap;
import java.util.Map;

/** Group based on knowing the secret code. */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CodeGroup extends Group {
    public static final String TYPE = "code";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public CodeGroup() {}
    
    public CodeGroup(String id, LocalizedString title, LocalizedString description,
					 String code, String codeHash, Map<String, String> properties) {
    	super(id, title, description, properties);
    	this.code = code;
    	this.codeHash = codeHash;
    }
    
	@Override
	public Object clone() {
		return new CodeGroup(id,
			(title != null) ? (LocalizedString) title.clone() : null,
            (description != null) ? (LocalizedString) description.clone() : null,
			code, codeHash,
			((properties != null) ? new LinkedHashMap<>(properties) : null));
	}
	
	/** The group's secret code. */
    @JsonInclude(Include.NON_NULL)
    public String code;
    
	/** SHA1(groupId + code), base64 encoded. */
    @JsonInclude(Include.NON_NULL)
    public String codeHash;
}