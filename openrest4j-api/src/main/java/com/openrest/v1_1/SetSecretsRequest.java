package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SetSecretsRequest extends Request {
    public static final String TYPE = "set_secrets";
    private static final long serialVersionUID = 1L;

    /** Default constructor for JSON deserialization. */
    public SetSecretsRequest() {}

    public SetSecretsRequest(String accessToken, String organizationId, Secrets secrets) {
        this.accessToken = accessToken;
        this.organizationId = organizationId;
        this.secrets = secrets;
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    @JsonInclude(Include.NON_NULL)
    public String organizationId;

    @JsonInclude(Include.NON_NULL)
    public Secrets secrets;
}
