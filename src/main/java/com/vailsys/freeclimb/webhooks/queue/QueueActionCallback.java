package com.vailsys.freeclimb.webhooks.queue;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class QueueActionCallback extends VoiceRequest {
    private QueueResult queueResult;
    private Integer queueTime;

    private QueueActionCallback() {
    }

    public static QueueActionCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, QueueActionCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public QueueResult getQueueResult() {
        return queueResult;
    }

    public Integer getQueueTime() {
        return queueTime;
    }
}
