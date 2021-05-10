package com.vailsys.freeclimb.api.phoneNumber;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb IncomingPhonenumber instances. This
 * object will be automatically created by a
 * {@link com.vailsys.freeclimb.api.phoneNumber.IncomingPhoneNumberRequester}
 * inside a {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its
 * creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class IncomingPhoneNumberList extends FreeClimbList<IncomingPhoneNumber> {
    /**
     * Creates a new IncomingPhoneNumberList.
     *
     * @param credAccountId the accountId to use in requests for subsequent pages.
     * @param credApiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage       the raw JSON string representing a page of a conference
     *                      list from the FreeClimb API.
     * @throws FreeClimbException when the request fails or the JSON is invalid.
     */
    public IncomingPhoneNumberList(String credAccountId, String credApiKey, String rawPage)
            throws FreeClimbException {
        super(credAccountId, credApiKey, rawPage, "incomingPhoneNumbers", IncomingPhoneNumber.class);
    }
}
