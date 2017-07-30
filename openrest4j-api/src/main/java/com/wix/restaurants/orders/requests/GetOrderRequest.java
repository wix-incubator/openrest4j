package com.wix.restaurants.orders.requests;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.v1_1.Order;
import com.openrest.v1_1.Viewport;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.requests.Request;

import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetOrderRequest extends Request {
	public static final String TYPE = "get_order";
    private static final long serialVersionUID = 1L;
    
    /** Default constructor for JSON deserialization. */
    public GetOrderRequest() {}
    
    public GetOrderRequest(String accessToken, String shareToken, String ownerToken,
                           String orderId, String viewMode, Boolean anonymize,
                           Set<String> fields, Locale locale, Viewport viewport, Boolean embed,
                           Boolean printHeader, Boolean printCsc) {
    	this.accessToken = accessToken;
        this.shareToken = shareToken;
        this.ownerToken = ownerToken;
    	this.orderId = orderId;
    	this.viewMode = viewMode;
    	this.anonymize = anonymize;
    	this.fields = fields;
    	this.locale = locale;
    	this.viewport = viewport;
    	this.embed = embed;
    	this.printHeader = printHeader;
    	this.printCsc = printCsc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GetOrderRequest that = (GetOrderRequest) o;

        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (shareToken != null ? !shareToken.equals(that.shareToken) : that.shareToken != null) return false;
        if (ownerToken != null ? !ownerToken.equals(that.ownerToken) : that.ownerToken != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (viewMode != null ? !viewMode.equals(that.viewMode) : that.viewMode != null) return false;
        if (restaurantView != null ? !restaurantView.equals(that.restaurantView) : that.restaurantView != null) return false;
        if (anonymize != null ? !anonymize.equals(that.anonymize) : that.anonymize != null) return false;
        if (locale != null ? !locale.equals(that.locale) : that.locale != null) return false;
        if (viewport != null ? !viewport.equals(that.viewport) : that.viewport != null) return false;
        if (embed != null ? !embed.equals(that.embed) : that.embed != null) return false;
        if (printHeader != null ? !printHeader.equals(that.printHeader) : that.printHeader != null) return false;
        if (printCsc != null ? !printCsc.equals(that.printCsc) : that.printCsc != null) return false;
        return fields != null ? fields.equals(that.fields) : that.fields == null;
    }

    @Override
    public int hashCode() {
        int result = accessToken != null ? accessToken.hashCode() : 0;
        result = 31 * result + (shareToken != null ? shareToken.hashCode() : 0);
        result = 31 * result + (ownerToken != null ? ownerToken.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (viewMode != null ? viewMode.hashCode() : 0);
        result = 31 * result + (restaurantView != null ? restaurantView.hashCode() : 0);
        result = 31 * result + (anonymize != null ? anonymize.hashCode() : 0);
        result = 31 * result + (locale != null ? locale.hashCode() : 0);
        result = 31 * result + (viewport != null ? viewport.hashCode() : 0);
        result = 31 * result + (embed != null ? embed.hashCode() : 0);
        result = 31 * result + (printHeader != null ? printHeader.hashCode() : 0);
        result = 31 * result + (printCsc != null ? printCsc.hashCode() : 0);
        result = 31 * result + (fields != null ? fields.hashCode() : 0);
        return result;
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
    
    /** Use viewMode */
    @Deprecated
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean restaurantView = Boolean.FALSE;

    @JsonInclude(Include.NON_DEFAULT)
    public Boolean anonymize = Boolean.FALSE;
    
    /** For Order.html, if null Order.locale will be used. */
    @JsonInclude(Include.NON_NULL)
	public Locale locale;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_NULL)
    public Viewport viewport;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean embed = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printHeader = Boolean.FALSE;
    
    /** For Order.html. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean printCsc = Boolean.FALSE;
    
    @JsonInclude(Include.NON_NULL)
	public Set<String> fields;
}
