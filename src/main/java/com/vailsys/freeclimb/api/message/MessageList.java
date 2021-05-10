package com.vailsys.freeclimb.api.message;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Message instances. This object will
 * be automatically created by a
 * {@link com.vailsys.freeclimb.api.message.MessagesRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 */
public class MessageList extends FreeClimbList<Message> {
    /**
     * Creates a new MessageList.
     *
     * @param accountId the accountId to use in requests for subsequent pages.
     * @param apiKey the apiKey to use in requests to subsequent pages.
     * @param rawPage   the raw JSON string representing a page of a message list
     *                  from the FreeClimb API
     * @throws FreeClimbException When the page is invalid JSON.
     */
    public MessageList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "messages", Message.class);
    }
}
