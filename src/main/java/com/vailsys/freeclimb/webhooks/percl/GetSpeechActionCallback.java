package com.vailsys.freeclimb.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class GetSpeechActionCallback extends VoiceRequest {
    private SpeechReason reason;
    private String recognitionResult;
    private Integer confidence;

    private GetSpeechActionCallback() {
    }

    public static GetSpeechActionCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, GetSpeechActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public SpeechReason getReason() {
        return reason;
    }

    public String getRecognitionResult() {
        return recognitionResult;
    }

    public Integer getConfidence() {
        return confidence;
    }
}
