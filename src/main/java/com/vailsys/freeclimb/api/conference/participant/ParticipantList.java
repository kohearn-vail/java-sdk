package com.vailsys.freeclimb.api.conference.participant;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Participant instances. This object
 * will be automatically created by a
 * {@link com.vailsys.freeclimb.api.conference.participant.ParticipantsRequester}
 * inside a {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its
 * creation should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class ParticipantList extends FreeClimbList<Participant> {

    /**
     * Creates a new ParticipantList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage   the raw JSON string representing a page of a participant
     *                  list from the FreeClimb API.
     * @throws FreeClimbException when the JSON is invalid.
     */
    public ParticipantList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "participants", Participant.class);
    }
}
