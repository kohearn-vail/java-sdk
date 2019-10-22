package com.vailsys.freeclimb.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class GetDigitsActionCallback extends VoiceRequest {
    private String digits;
    private DigitReason reason;

    private GetDigitsActionCallback() {
    }

    public static GetDigitsActionCallback createFromJson(String json) throws FreeClimbException {
        try {
            return gson.fromJson(json, GetDigitsActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException ex) {
            throw new FreeClimbJSONException(ex);
        }
    }

    public String getDigits() {
        return digits;
    }

    public DigitReason getReason() {
        return reason;
    }
}
