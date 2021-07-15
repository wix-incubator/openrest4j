package com.openrest.v1_1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.openrest.olo.dispatches.DispatchInfo;
import com.wix.restaurants.availability.Availability;
import com.wix.restaurants.i18n.Locale;
import com.wix.restaurants.i18n.LocalizedString;
import com.wix.restaurants.orders.OrdersInfo;
import com.wix.restaurants.reservations.ReservationsInfo;

import java.util.*;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Restaurant extends Organization {
	public static final String TYPE = "restaurant";
	private static final long serialVersionUID = 1L;

    public Restaurant(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                      String distributorId, String chainId, LocalizedString title,
                      LocalizedString description, Contact contact, Address address,
                      Map<String, LocalizedString> messages,
                      Availability openTimes, List<DispatchInfo> deliveryInfos,
                      String timezone, String currency, Locale locale, Set<Locale> locales,
                      Set<String> paymentTypes, Boolean multiPaymentDisabled, CreditcardsInfo creditcardsInfo,
                      DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                      Map<String, String> media, List<AppInfo> apps, Map<String, String> properties,
                      Boolean closed, Set<Product> products, Map<String, Double> features, String currentLocationId,
                      String defaultLocationIdAtTimeOfMigration, LocalizedString locationName, List<Location> locations) {
    	this(id, alias, affiliateId, externalIds, created, modified,
             distributorId, chainId, title, description, contact, address, messages,
             openTimes, deliveryInfos, timezone,  currency,  locale,  locales,
             paymentTypes,  multiPaymentDisabled,  creditcardsInfo,
             deliveriesInfo, orders, reservations, media, apps, properties,
             closed, products ,features, currentLocationId, defaultLocationIdAtTimeOfMigration, locationName, locations, null);
    }

    public Restaurant(String id, String alias, String affiliateId, Map<String, String> externalIds, Date created, Date modified,
                      String distributorId, String chainId, LocalizedString title,
                      LocalizedString description, Contact contact, Address address,
                      Map<String, LocalizedString> messages,
                      Availability openTimes, List<DispatchInfo> deliveryInfos,
                      String timezone, String currency, Locale locale, Set<Locale> locales,
                      Set<String> paymentTypes, Boolean multiPaymentDisabled, CreditcardsInfo creditcardsInfo,
                      DeliveriesInfo deliveriesInfo, OrdersInfo orders, ReservationsInfo reservations,
                      Map<String, String> media, List<AppInfo> apps, Map<String, String> properties,
                      Boolean closed, Set<Product> products, Map<String, Double> features, String currentLocationId,
                      String defaultLocationIdAtTimeOfMigration, LocalizedString locationName, List<Location> locations, String defaultDispatchType) {
        super(id, alias, affiliateId, externalIds, created, modified, title, description, locale, locales, messages,
                contact, address, timezone, currency, apps, properties,
                media, closed, products);

        this.distributorId = distributorId;
        this.chainId = chainId;
        this.openTimes = openTimes;
        this.deliveryInfos = deliveryInfos;
        this.paymentTypes = paymentTypes;
        this.multiPaymentDisabled = multiPaymentDisabled;
        this.creditcardsInfo = creditcardsInfo;
        this.deliveriesInfo = deliveriesInfo;
        this.orders = orders;
        this.reservations = reservations;
        this.features = features;
        this.currentLocationId = currentLocationId;
        this.defaultLocationIdAtTimeOfMigration = defaultLocationIdAtTimeOfMigration;
        this.locationName = locationName;
        this.locations = locations;
        this.defaultDispatchType = defaultDispatchType;
    }


    /** Default constructor for JSON deserialization. */
    public Restaurant() {}

    @Override
    public Restaurant clone() {
        return cloneImpl();
    }

    /** @return a shallow copy of this object. */
    @Override
	protected Restaurant cloneImpl() {
    	return new Restaurant(id, alias, affiliateId,
    			((externalIds != null) ? new LinkedHashMap<>(externalIds) : null),
                (created != null) ? (Date) created.clone() : null,
                (modified != null) ? (Date) modified.clone() : null,
                distributorId, chainId,
    			((title != null) ? title.clone() : null),
    			((description != null) ? description.clone() : null),
    			((contact != null) ? contact.clone() : null),
    			((address != null) ? address.clone() : null),
    			cloneMessages(messages),
    			((openTimes != null) ? openTimes.clone() : null),
                DispatchInfo.clone(deliveryInfos),
    			timezone, currency, locale,
    			((locales != null) ? new LinkedHashSet<>(locales) : null),
    			((paymentTypes != null) ? new LinkedHashSet<>(paymentTypes) : null),
    			multiPaymentDisabled,
                ((creditcardsInfo != null) ? creditcardsInfo.clone() : null),
                ((deliveriesInfo != null) ? deliveriesInfo.clone() : null),
                ((orders != null) ? orders.clone() : null),
                ((reservations != null) ? reservations.clone() : null),
                ((media != null) ? new LinkedHashMap<>(media) : null),
                AppInfo.clone(apps),
                ((properties != null) ? new LinkedHashMap<>(properties) : null),
                closed, Product.clone(products),
                ((features != null) ? new LinkedHashMap<>(features) : null),
                currentLocationId,
                defaultLocationIdAtTimeOfMigration,
                ((locationName != null) ? locationName.clone() : null),
                Location.clone(locations),
                defaultDispatchType);
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Restaurant that = (Restaurant) o;
        return Objects.equals(distributorId, that.distributorId) &&
                Objects.equals(chainId, that.chainId) &&
                Objects.equals(openTimes, that.openTimes) &&
                Objects.equals(deliveryInfos, that.deliveryInfos) &&
                Objects.equals(paymentTypes, that.paymentTypes) &&
                Objects.equals(multiPaymentDisabled, that.multiPaymentDisabled) &&
                Objects.equals(creditcardsInfo, that.creditcardsInfo) &&
                Objects.equals(deliveriesInfo, that.deliveriesInfo) &&
                Objects.equals(orders, that.orders) &&
                Objects.equals(reservations, that.reservations) &&
                Objects.equals(features, that.features) &&
                Objects.equals(currentLocationId, that.currentLocationId) &&
                Objects.equals(defaultLocationIdAtTimeOfMigration, that.defaultLocationIdAtTimeOfMigration) &&
                Objects.equals(locationName, that.locationName) &&
                Objects.equals(locations, that.locations) &&
                Objects.equals(defaultDispatchType, that.defaultDispatchType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), distributorId, chainId, openTimes, deliveryInfos, paymentTypes, multiPaymentDisabled, creditcardsInfo, deliveriesInfo, orders, reservations, features, currentLocationId, defaultLocationIdAtTimeOfMigration, locationName, locations, defaultDispatchType);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "distributorId='" + distributorId + '\'' +
                ", chainId='" + chainId + '\'' +
                ", openTimes=" + openTimes +
                ", deliveryInfos=" + deliveryInfos +
                ", paymentTypes=" + paymentTypes +
                ", multiPaymentDisabled=" + multiPaymentDisabled +
                ", creditcardsInfo=" + creditcardsInfo +
                ", deliveriesInfo=" + deliveriesInfo +
                ", orders=" + orders +
                ", reservations=" + reservations +
                ", features=" + features +
                ", currentLocationId=" + currentLocationId +
                ", defaultLocationIdAtTimeOfMigration=" + defaultLocationIdAtTimeOfMigration +
                ", locationName=" + locationName +
                ", locations=" + locations +
                ", id='" + id + '\'' +
                ", alias='" + alias + '\'' +
                ", affiliateId='" + affiliateId + '\'' +
                ", externalIds=" + externalIds +
                ", created=" + created +
                ", modified=" + modified +
                ", title=" + title +
                ", description=" + description +
                ", contact=" + contact +
                ", address=" + address +
                ", timezone='" + timezone + '\'' +
                ", currency='" + currency + '\'' +
                ", locale=" + locale +
                ", locales=" + locales +
                ", messages=" + messages +
                ", apps=" + apps +
                ", properties=" + properties +
                ", media=" + media +
                ", closed=" + closed +
                ", products=" + products +
                ", defaultDispatchType=" + defaultDispatchType +
                '}';
    }

    /** The distributor in charge of this restaurant. */
    @JsonInclude(Include.NON_NULL)
    public String distributorId;

    /** The current location id. */
    @JsonInclude(Include.NON_NULL)
    public String currentLocationId;

    /** The default location id at time of migration. */
    @JsonInclude(Include.NON_NULL)
    public String defaultLocationIdAtTimeOfMigration;

    /** The current location name. */
    @JsonInclude(Include.NON_DEFAULT)
    public LocalizedString locationName = LocalizedString.empty;

    /** The chain this restaurant is part of. */
    @JsonInclude(Include.NON_NULL)
    public String chainId;
    
    /** Restaurant opening times. */
    @JsonInclude(Include.NON_DEFAULT)
    public Availability openTimes = new Availability();

    /** Information regarding the different delivery destinations. */
    @JsonInclude(Include.NON_NULL)
    public List<DispatchInfo> deliveryInfos = new LinkedList<>();

    /** Available payment methods. */
    @JsonInclude(Include.NON_DEFAULT)
    public Set<String> paymentTypes = new LinkedHashSet<>();
    
    /** Whether or not the restaurant supports multiple payments in a single order. */
    @JsonInclude(Include.NON_DEFAULT)
    public Boolean multiPaymentDisabled = Boolean.FALSE;
    
    @JsonInclude(Include.NON_NULL)
    public CreditcardsInfo creditcardsInfo = new CreditcardsInfo();

    @JsonInclude(Include.NON_NULL)
    public DeliveriesInfo deliveriesInfo;

    @JsonInclude(Include.NON_NULL)
    public OrdersInfo orders;

    @JsonInclude(Include.NON_NULL)
    public ReservationsInfo reservations;

    /** Information regarding the locations of the restaurant. */
    @JsonInclude(Include.NON_DEFAULT)
    public List<Location> locations = new LinkedList<>();
    /**
     * Maps feature-IDs to their values. The values correspond to how strongly the feature
     * is relevant for the restaurant, which influences its position in search results.
     * 
     * For example, a restaurant with "hamburger" feature = 3.7 will appear before a
     * restaurant with the same feature = 2.3 when customers search for hamburgers.
     */
    @JsonInclude(Include.NON_DEFAULT)
    public Map<String, Double> features = new LinkedHashMap<>();

    /** The default dispatch type. */
    @JsonInclude(Include.NON_NULL)
    public String defaultDispatchType;
}
