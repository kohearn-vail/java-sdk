package com.vailsys.freeclimb.api.phoneNumber;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb CallingNumber instances. This object
 * will be automatically created by a
 * {@link com.vailsys.freeclimb.api.phoneNumber.CallingNumberRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class CallingNumberList extends FreeClimbList<CallingNumber> {

    /**
     * Creates a new CallingNumberList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage   the raw JSON string representing a page of a calling number
     *                  list from the FreeClimb API.
     * @throws FreeClimbException when the request fails or the JSON is invalid.
     */
    public CallingNumberList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "callingNumbers", CallingNumber.class);
    }
}
