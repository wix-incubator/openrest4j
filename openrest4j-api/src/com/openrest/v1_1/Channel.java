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
	 * @see http://www.restcloud.net/
	 * param: restcloud restaurant-id.
	 */
    public static final String CHANNEL_RESTCLOUD = "net.restcloud";
	
    /** All known channels. */
    public static final Set<String> ALL_CHANNELS = new HashSet<String>(Arrays.asList(
    		CHANNEL_FAX, CHANNEL_SMS, CHANNEL_VOICE, CHANNEL_RESTCLOUD));
}
