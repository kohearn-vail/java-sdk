package com.vailsys.freeclimb.webhooks.conference;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class ConferenceCreateActionCallback extends VoiceRequest {
    public ConferenceCreateActionCallback() {
    }

    public static ConferenceCreateActionCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, ConferenceCreateActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex) {
            throw new FreeClimbJSONException(ex);
        }
    }
}
