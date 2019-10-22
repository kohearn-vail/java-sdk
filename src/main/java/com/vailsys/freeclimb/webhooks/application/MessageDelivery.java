package com.vailsys.freeclimb.webhooks.application;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.api.message.Direction;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.api.message.Status;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

/**
 * A MessageDelivery represents the JSON object that is sent to the smsUrl /
 * smsFallbackUrl of FreeClimb Applications when an SMS message is sent to the
 * platform.
 */
public class MessageDelivery extends FreeClimbRequest {
    private String messageId;
    private String text;
    private Direction direction;
    private String applicationId;
    private Status status;
    private String phoneNumberId;

    public static MessageDelivery createFromJson(String jsonString) throws FreeClimbJSONException {
        try {
            return gson.fromJson(jsonString, MessageDelivery.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public String getMessageId() {
        return messageId;
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
