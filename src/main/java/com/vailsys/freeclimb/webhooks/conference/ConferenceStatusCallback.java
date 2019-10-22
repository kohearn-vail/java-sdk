package com.vailsys.freeclimb.webhooks.conference;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.api.conference.ConferenceStatus;
import com.vailsys.freeclimb.webhooks.StatusCallback;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class ConferenceStatusCallback extends StatusCallback {
    private ConferenceStatus status;

    private ConferenceStatusCallback() {
    }

    public static ConferenceStatusCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, ConferenceStatusCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex) {
            throw new FreeClimbJSONException(ex);
        }
    }

    public ConferenceStatus getStatus() {
        return status;
    }
}
