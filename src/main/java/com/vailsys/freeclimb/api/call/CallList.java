package com.vailsys.freeclimb.api.call;

import com.vailsys.freeclimb.api.FreeClimbCommon;
import com.vailsys.freeclimb.api.FreeClimbList;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;

/**
 * Represents a paginated list of FreeClimb Call instances. This object will be
 * automatically created by a
 * {@link com.vailsys.freeclimb.api.call.CallsRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class CallList extends FreeClimbList<Call> {

	/**
	 * Creates a new CallList.
	 * 
	 * @param accountId the accountId to use in requests for subsequent pages.
	 * @param apiKey the apiKey to use in requests for subsequent pages.
	 * @param rawPage   the raw JSON string representing a page of a call list from
	 *                  the FreeClimb API.
	 * @throws FreeClimbException when the JSON is invalid.
	 */
	public CallList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
		super(accountId, apiKey, rawPage, "calls", Call.class);
	}
}
