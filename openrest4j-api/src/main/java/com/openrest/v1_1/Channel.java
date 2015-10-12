package com.openrest.v1_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Channel {
	private Channel() {}
	
	/**
	 * Email.
	 * param: the email.
	 */
    public static final String CHANNEL_EMAIL = "email";
	/**
	 * Fax.
	 * param: phone number in E.164 format.
	 */
    public static final String CHANNEL_FAX = "fax";
	/**
	 * SMS.
	 * param: phone number in E.164 format.
	 */
    public static final String CHANNEL_SMS = "sms";
	/**
	 * Voice call.
	 * param: phone number in E.164 format.
	 */
    public static final String CHANNEL_VOICE = "voice";
	/**
	 * @see <a href="http://www.restcloud.net/">RestCloud</a>
	 * param: restcloud restaurant-id.
	 */
    public static final String CHANNEL_RESTCLOUD = "net.restcloud";
	/**
	 * FRSvision POS (standard).
	 * param: port number in FRSvision's router.
	 */
    public static final String CHANNEL_FRSVISION_POS = "com.frsvision.pos";
	/**
	 * FRSvision POS (burgeranch).
	 * param: burgeranch branch number.
	 */
    public static final String CHANNEL_FRSVISION_BURGERANCH = "com.frsvision.burgeranch";
	/**
	 * Beecomm POS.
	 * param: Beecomm restaurant-id.
	 */
    public static final String CHANNEL_BEECOMM = "com.beecomm";
	/**
	 * Google CloudPrint.
	 * param: Google CloudPrint printer-id.
	 */
    public static final String CHANNEL_CLOUDPRINT = "com.google.cloudprint";
	/**
	 * Presto POS.
	 * param: port number in Presto's router.
	 */
    public static final String CHANNEL_PRESTO = "il.co.presto";

    /**
     * RSD POS.
     * param: ignored.
     */
    public static final String CHANNEL_RSD = "il.co.rsd";

    /** All known channels. */
    public static final Set<String> ALL_CHANNELS = new HashSet<>(Arrays.asList(
    		CHANNEL_EMAIL, CHANNEL_FAX, CHANNEL_SMS, CHANNEL_VOICE, CHANNEL_RESTCLOUD,
    		CHANNEL_FRSVISION_POS, CHANNEL_FRSVISION_BURGERANCH, CHANNEL_BEECOMM,
    		CHANNEL_CLOUDPRINT, CHANNEL_PRESTO, CHANNEL_RSD));
    
    /** Special channel param that's used as placeholder for the customer's details, e.g. by notifications. */
    public static final String CHANNEL_PARAM_CUSTOMER = "_customer_";
}
