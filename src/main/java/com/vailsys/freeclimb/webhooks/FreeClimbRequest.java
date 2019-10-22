package com.vailsys.freeclimb.webhooks;

import com.vailsys.freeclimb.api.FreeClimbJSONException;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.call.CallStatus;
import com.vailsys.freeclimb.api.call.Direction;

/**
 * A FreeClimbRequest represents the JSON object that is sent to the webhooks
 * (voiceUrl, voiceFallbackUrl, etc.) of FreeClimb applications. All webhooks
 * except the statusCallbackUrl will receive a payload in this form.
 */
public class FreeClimbRequest {
    private String requestId;
    private String accountId;
    private RequestType requestType;
    private String from;
    private String to;

    /**
     * Helper method to build a FreeClimbRequest object from the JSON string sent to
     * your application by FreeClimb
     * 
     * @param rawJson The JSON string to parse into a FreeClimbRequest.
     * @return the FreeClimbRequest object representing the provided JSON.
     * @throws FreeClimbJSONException when the JSON is invalid.
     */
    public static FreeClimbRequest fromJson(String rawJson) throws FreeClimbJSONException {
        try {
            return gson.fromJson(rawJson, FreeClimbRequest.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public String getRequestId() {
        return this.requestId;
    }

    public String getAccountId() {
        return this.accountId;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public String getFrom() {
        return this.from;
    }

    public String getTo() {
        return this.to;
    }
}
