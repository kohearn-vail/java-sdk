package com.vailsys.freeclimb.api.recording;

import com.vailsys.freeclimb.api.FreeClimbCommon;
import com.vailsys.freeclimb.api.FreeClimbList;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;

/**
 * Represents a paginated list of FreeClimb Recording instances. This object
 * will be automatically created by a
 * {@link com.vailsys.freeclimb.api.recording.RecordingsRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and it's creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class RecordingList extends FreeClimbList<Recording> {

	/**
	 * Creates a new RecordingList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param apiKey the apiKey to use in requests for subsequent pages.
	 * @param rawPage   the raw JSON string representing a page of a recordings list
	 *                  from the FreeClimb API.
	 * @throws FreeClimbException when the page is not valid JSON.
	 */
	public RecordingList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
		super(accountId, apiKey, rawPage, "recordings", Recording.class);
	}
}
