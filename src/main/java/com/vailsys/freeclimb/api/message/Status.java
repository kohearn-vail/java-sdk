package com.vailsys.freeclimb.api.message;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the different possible predefined values of the
 * {@code status} field inside a FreeClimb MessageDelivery callback. It
 * indicates the status of the message.
 */
public enum Status {
    @SerializedName("new")
    NEW, @SerializedName("queued")
    QUEUED, @SerializedName("rejected")
    REJECTED, @SerializedName("sending")
    SENDING, @SerializedName("sent")
    SENT, @SerializedName("failed")
    FAILED, @SerializedName("received")
    RECEIVED, @SerializedName("undelivered")
    UNDELIVERED, @SerializedName("expired")
    EXPIRED, @SerializedName("deleted")
    DELETED, @SerializedName("unknown")
    UNKNOWN
}
