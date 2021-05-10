package com.vailsys.freeclimb.api.log;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Log instances. This object will be
 * automatically created by a {@link com.vailsys.freeclimb.api.log.LogRequester}
 * inside a {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its
 * creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class LogList extends FreeClimbList<Log> {

    /**
     * Creates a new LogList.
     *
     * @param credAccountId the accountId to use in requests for subsequent pages.
     * @param credApiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage       the raw JSON string representing a page of a log list
     *                      from the FreeClimb API.
     * @throws FreeClimbException when the JSON is invalid.
     */
    public LogList(String credAccountId, String credApiKey, String rawPage) throws FreeClimbException {
        super(credAccountId, credApiKey, rawPage, "logs", Log.class);
    }
}
