package com.vailsys.freeclimb.webhooks.application;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class ApplicationVoiceCallback extends VoiceRequest {

    private ApplicationVoiceCallback() {
    }

    public static ApplicationVoiceCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, ApplicationVoiceCallback.class);
        } catch (JsonIOException jioe) {
            throw new FreeClimbJSONException(jioe);
        } catch (JsonSyntaxException jse) {
            throw new FreeClimbJSONException(jse);
        }
    }

}
