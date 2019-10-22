package com.vailsys.freeclimb.api.message;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbCommon;
import com.vailsys.freeclimb.api.FreeClimbJSONException;

/**
 * This class represents a FreeClimb Message instance. Message instances are
 * created by the SDK whenever a message would be returned by the API; these
 * primarily come from a
 * {@link com.vailsys.freeclimb.api.message.MessagesRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance.<br>
 * <br>
 * Messages are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.freeclimb.api.message.MessagesRequester
 * @see com.vailsys.freeclimb.api.FreeClimbClient
 */
public class Message extends FreeClimbCommon {
    /**
     * The messageId for this message instance.
     */
    private String messageId;

    /**
     * The accountId for the account that sent this message
     */
    private String accountId;

    /**
     * The phone number or SIP URI that received this message.
     */
    private String to;

    /**
     * The phone number or SIP URI that sent this message.
     */
    private String from;

    /**
     * The text body of this message. Up to 254 characters long.
     */
    private String text;

    /**
     * The direction (inbound, outbound) of the message.
     *
     * @see com.vailsys.freeclimb.api.message.Direction
     */
    private Direction direction;

    /**
     * The url that will be requested when the status of an outbound message
     * changes.
     */
    private String notificationUrl;

    /**
     * The message status.
     */
    private Status status;

    /**
     * Converts the provided JSON string into a Message object.
     *
     * @param json A JSON string representing a FreeClimb Message instance.
     * @return A Message object equivalent to the JSON string passed in.
     * @throws FreeClimbJSONException When the JSON is invalid.
     */
    public static Message fromJson(String json) throws FreeClimbJSONException {
        try {
            return gson.fromJson(json, Message.class);
        } catch (JsonSyntaxException jse) {
            throw new FreeClimbJSONException(jse);
        }
    }

    /**
     * Retrieve the messageId for this message from the object.
     *
     * @return The messageId for this message.
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Retrieve the accountId for this message from the object.
     *
     * @return The accountId for this message.
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Retrieve the to number (DNIS) for this message from the object.
     *
     * @return The to number (DNIS) for this message.
     */
    public String getTo() {
        return to;
    }

    /**
     * Retrieve the from number (ANI) for this message from the object.
     *
     * @return The from number (ANI) for this message.
     */
    public String getFrom() {
        return from;
    }

    /**
     * Retrieve the text body for this message from the object.
     *
     * @return The text body for this message.
     */
    public String getText() {
        return text;
    }

    /**
     * Retrieve the direction of this message from the object.
     *
     * @return The direction of this message.
     * @see com.vailsys.freeclimb.api.message.Direction
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Retrieve the notificationUrl of this message from the object.
     *
     * @return The notificationUrl of this message.
     */
    public String getNotificationUrl() {
        return notificationUrl;
    }

    /**
     * Retrieve the status of this message from the object.
     *
     * @return The status of this message.
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Check if this message equals another. This is done by comparing all fields in
     * the message for equality.
     *
     * @param that The Message object for comparison.
     * @return {@code true} if messages are equal, {@code false} otherwise.
     */
    public boolean equals(Message that) {
        boolean result;

        result = super.equals(that);

        if (this.messageId != null) {
            result = result && that.messageId.equals(this.messageId);
        } else {
            result = result && that.messageId == null;
        }

        if (this.accountId != null) {
            result = result && that.accountId.equals(this.accountId);
        } else {
            result = result && that.accountId == null;
        }

        if (this.to != null) {
            result = result && that.to.equals(this.to);
        } else {
            result = result && that.to == null;
        }

        if (this.from != null) {
            result = result && that.from.equals(this.from);
        } else {
            result = result && that.from == null;
        }

        if (this.text != null) {
            result = result && that.text.equals(this.text);
        } else {
            result = result && that.text == null;
        }

        if (this.direction != null) {
            result = result && that.direction.equals(this.direction);
        } else {
            result = result && that.direction == null;
        }

        if (this.notificationUrl != null) {
            result = result && that.notificationUrl.equals(this.notificationUrl);
        } else {
            result = result && that.notificationUrl == null;
        }

        if (this.status != null) {
            result = result && that.status.equals(this.status);
        } else {
            result = result && that.status == null;
        }

        return result;
    }
}
