package com.vailsys.freeclimb.api.phoneNumber;

import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

/**
 * This class represents a FreeClimb AvailablePhoneNumber instance.
 * AvailablePhoneNumber objects are created by the SDK whenever an
 * availablephonenumber instance would be returned by the API; these primarily
 * come from a
 * {@link com.vailsys.freeclimb.api.phoneNumber.AvailablePhoneNumberRequester}
 * inside a {@link com.vailsys.freeclimb.api.FreeClimbClient} instance.<br>
 * <br>
 * AvailablePhoneNumbers are immutable and intended only to be used to read
 * information returned from the API in a language accessible way.
 *
 * @see com.vailsys.freeclimb.api.phoneNumber.AvailablePhoneNumberRequester
 * @see com.vailsys.freeclimb.api.FreeClimbClient
 */
public class AvailablePhoneNumber extends PhoneNumber {
    /**
     * The voiceEnabled setting for this phone number.
     */
    private boolean voiceEnabled;
    /**
     * The smsEnabled setting for this phone number.
     */
    private boolean smsEnabled;
    /**
     * The region of this phone number.
     */
    private String region;
    /**
     * The country of this phone number.
     */
    private String country;

    /**
     * Converts the provided JSON string into an AvailablePhoneNumber object.
     *
     * @param json A JSON string representing an AvailablePhoneNumber instance.
     * @return An AvailablePhoneNumber object equivalent to the JSON string passed
     *         in.
     * @throws FreeClimbJSONException when the JSON is not valid.
     */
    public static AvailablePhoneNumber fromJson(String json) throws FreeClimbJSONException {
        try {
            return gson.fromJson(json, AvailablePhoneNumber.class);
        } catch (JsonSyntaxException jse) {
            throw new FreeClimbJSONException(jse);
        }
    }

    /**
     * Retrieve the voiceEnabled setting from the object.
     *
     * @return The voiceEnabled for this AvailablePhoneNumber.
     */
    public boolean isVoiceEnabled() {
        return voiceEnabled;
    }

    /**
     * Retrieve the smsEnabled setting from the object.
     *
     * @return The smsEnabled for this AvailablePhoneNumber.
     */
    public boolean isSmsEnabled() {
        return smsEnabled;
    }

    /**
     * Retrieve the region of the phone number.
     *
     * @return The region of this AvailablePhoneNumber.
     */
    public String getRegion() {
        return region;
    }

    /**
     * Retrieve the country of the phone number.
     *
     * @return The country of this AvailablePhoneNumber.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Check if this AvailablePhoneNumber equals another. This is done by comparing
     * all fields in the AvailablePhoneNumber for equality.
     *
     * @param that The AvailablePhoneNumber object for comparison.
     * @return {@code true} if available phone numbers are equals, {@code false}
     *         otherwise.
     */
    public boolean equals(AvailablePhoneNumber that) {
        boolean result = super.equals(that);
        result = result && (this.isVoiceEnabled() == that.isVoiceEnabled());
        result = result && (this.isSmsEnabled() == that.isSmsEnabled());
        if (this.getRegion() != null) {
            result = result && that.getRegion().equals(this.getRegion());
        } else {
            result = result && that.getRegion() == null;
        }

        if (this.getCountry() != null) {
            result = result && that.getCountry().equals(this.getCountry());
        } else {
            result = result && that.getCountry() == null;
        }

        return result;
    }
}
