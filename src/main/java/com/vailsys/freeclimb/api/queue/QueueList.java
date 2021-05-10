package com.vailsys.freeclimb.api.queue;

import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbList;

/**
 * Represents a paginated list of FreeClimb Queue instances. This object will be
 * automatically created by a
 * {@link com.vailsys.freeclimb.api.queue.QueuesRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance and its creation
 * should not be a concern of the SDK user.
 */
public class QueueList extends FreeClimbList<Queue> {
    /**
     * Creates a new QueuesList.
     *
     * @param accountId The accountId to use in requests for subsequent pages.
     * @param apiKey The apiKey to use in requests for subsequent pages.
     * @param rawPage   The raw JSON string representing a page of a conferences
     *                  list from the FreeClimb API.
     * @throws FreeClimbException if the provided page is not valid JSON.
     */
    public QueueList(String accountId, String apiKey, String rawPage) throws FreeClimbException {
        super(accountId, apiKey, rawPage, "queues", Queue.class);
    }
}
