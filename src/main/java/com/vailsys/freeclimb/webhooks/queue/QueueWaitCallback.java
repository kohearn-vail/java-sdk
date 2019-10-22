package com.vailsys.freeclimb.webhooks.queue;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class QueueWaitCallback extends VoiceRequest {
    private Integer queuePosition;
    private Integer queueTime;
    private Integer averageQueueTime;
    private Integer currentQueueSize;

    private QueueWaitCallback() {
    }

    public static QueueWaitCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, QueueWaitCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public Integer getQueuePosition() {
        return queuePosition;
    }

    public Integer getQueueTime() {
        return queueTime;
    }

    public Integer getAverageQueueTime() {
        return averageQueueTime;
    }

    public Integer getCurrentQueueSize() {
        return currentQueueSize;
    }
}
