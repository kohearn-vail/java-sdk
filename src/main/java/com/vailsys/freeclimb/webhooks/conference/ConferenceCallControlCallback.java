package com.vailsys.freeclimb.webhooks.conference;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class ConferenceCallControlCallback extends VoiceRequest {
    private String digits;

    public ConferenceCallControlCallback() {
    }

    public static ConferenceCallControlCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, ConferenceCallControlCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex) {
            throw new FreeClimbJSONException(ex);
        }
    }

    public String getDigits() {
        return digits;
    }
}
