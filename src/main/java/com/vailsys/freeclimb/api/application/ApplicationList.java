package com.vailsys.freeclimb.api.application;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Application instances. This object
 * will be automatically created by a
 * {@link com.vailsys.freeclimb.api.application.ApplicationsRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 */
public class ApplicationList extends FreeClimbList<Application> {
    /**
     * Creates a new ApplicationList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage   the raw JSON string representing a page of an application
     *                  list from the FreeClimb API
     * @throws FreeClimbException when the JSON is invalid.
     */
    public ApplicationList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "applications", Application.class);
    }
}
