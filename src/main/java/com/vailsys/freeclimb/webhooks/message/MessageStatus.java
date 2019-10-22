package com.vailsys.freeclimb.webhooks.message;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.api.message.Direction;
import com.vailsys.freeclimb.api.message.Status;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class MessageStatus extends FreeClimbRequest {
    private String messageId;
    private String callId;
    private String text;
    private Direction direction;
    private String applicationId;
    private Status status;
    private String phoneNumberId;

    public static MessageStatus createFromJson(String jsonString) throws FreeClimbJSONException {
        try {
            return gson.fromJson(jsonString, MessageStatus.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public String getMessageId() {
        return messageId;
    }

    public String getCallId() {
        return callId;
    }

    public String getText() {
        return text;
    }

    public Direction getDirection() {
        return direction;
    }

    public String getApplicationId() {
        return applicationId;
    }

    public Status getStatus() {
        return status;
    }

    public String getPhoneNumberId() {
        return phoneNumberId;
    }
}
