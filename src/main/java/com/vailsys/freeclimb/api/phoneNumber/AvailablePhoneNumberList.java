package com.vailsys.freeclimb.api.phoneNumber;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Available Phone Number instances.
 * This object will be automatically created by a
 * {@link AvailablePhoneNumberRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class AvailablePhoneNumberList extends FreeClimbList<AvailablePhoneNumber> {

    /**
     * Creates a new AvailablePhoneNumberList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage   the raw JSON string representing a page of an available
     *                  phone number list from the FreeClimb API.
     * @throws FreeClimbException when the JSON is invalid.
     *
     */
    public AvailablePhoneNumberList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "availablePhoneNumbers", AvailablePhoneNumber.class);
    }

}
