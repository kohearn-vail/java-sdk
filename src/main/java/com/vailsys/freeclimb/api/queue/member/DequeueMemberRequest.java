package com.vailsys.freeclimb.api.queue.member;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonIOException;

/**
 * Represents the fields that can be passed as a payload when dequeueing a queue
 * member.
 *
 * @see com.vailsys.freeclimb.api.queue.member.MembersRequester
 */
public class DequeueMemberRequest {
    public String requestId;

    /**
     * Setup a new dequeue payload using a requestId.
     *
     * @param requestId The ID of this request. Used for logging.
     */
    public DequeueMemberRequest(String requestId) {
        this.requestId = requestId;
    }

    public String toJson() throws JsonIOException {
        return gson.toJson(this);
    }
}
