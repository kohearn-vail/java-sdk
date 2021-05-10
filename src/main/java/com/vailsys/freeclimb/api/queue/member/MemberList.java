package com.vailsys.freeclimb.api.queue.member;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Member instances. This object will
 * be automatically created by a
 * {@link com.vailsys.freeclimb.api.queue.member.MembersRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 *
 * @see com.vailsys.freeclimb.api.FreeClimbList
 */
public class MemberList extends FreeClimbList<Member> {

    /**
     * Creates a new MemberList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests for subsequent pages.
     * @param rawPage   the raw JSON string representing a page of a member list
     *                  from the FreeClimb API.
     * @throws FreeClimbException when the page is not valid JSON.
     */
    public MemberList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "queueMembers", Member.class);
    }
}
