package com.vailsys.freeclimb.api.conference;

import com.vailsys.freeclimb.api.FreeClimbList;
import com.vailsys.freeclimb.api.FreeClimbException;

/**
 * Represents a paginated list of FreeClimb Conference instances. This object
 * will be automatically created by a
 * {@link com.vailsys.freeclimb.api.conference.ConferencesRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class ConferenceList extends FreeClimbList<Conference> {

	/**
	 * Creates a new ConferenceList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param apiKey the apiKey to use in requests for subsequent pages.
	 * @param rawPage   the raw JSON string representing a page of a conference list
	 *                  from the FreeClimb API.
	 * @throws FreeClimbException when the JSON is invalid.
	 */
	public ConferenceList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
		super(accountId, apiKey, rawPage, "conferences", Conference.class);
	}
}
