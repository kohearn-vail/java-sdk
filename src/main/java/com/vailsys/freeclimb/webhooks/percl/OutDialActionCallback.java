package com.vailsys.freeclimb.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class OutDialActionCallback extends VoiceRequest {

    private String dialCallId;

    private OutDialActionCallback() {
    }

    public static OutDialActionCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, OutDialActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public String getDialCallId() {
        return dialCallId;
    }
}
