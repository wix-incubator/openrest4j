package com.wix.restaurants.orders.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Order;
import com.wix.restaurants.requests.Request;

import java.util.Objects;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderRequest extends Request {
	public static final String TYPE = "get_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrderRequest() {}
    
    public GetOrderRequest(String accessToken, String shareToken, String ownerToken,
                           String orderId, String viewMode, Set<String> fields) {
    	this.accessToken = accessToken;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
    	this.orderId = orderId;
    	this.viewMode = viewMode;
    	this.fields = fields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GetOrderRequest that = (GetOrderRequest) o;
        return Objects.equals(accessToken, that.accessToken) &&
                Objects.equals(shareToken, that.shareToken) &&
                Objects.equals(ownerToken, that.ownerToken) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(viewMode, that.viewMode) &&
                Objects.equals(fields, that.fields);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, shareToken, ownerToken, orderId, viewMode, fields);
    }

    @JsonInclude(Include.NON_NULL)
    public String accessToken;

    /** @see Order#shareToken */
    @JsonInclude(Include.NON_NULL)
    public String shareToken;

    /** @see Order#ownerToken */
    @JsonInclude(Include.NON_NULL)
    public String ownerToken;

    @JsonInclude(Include.NON_NULL)
    public String orderId;
    
    /** @see com.wix.restaurants.Actors */
    @JsonInclude(Include.NON_NULL)
    public String viewMode;
    
    @JsonInclude(Include.NON_NULL)
	public Set<String> fields;
}
