package com.vailsys.freeclimb.webhooks;

import com.vailsys.freeclimb.api.call.CallStatus;
import com.vailsys.freeclimb.api.call.Direction;

public class VoiceRequest extends FreeClimbRequest {
    private String callId;
    private CallStatus callStatus;
    private Direction direction;
    private String conferenceId;
    private String queueId;

    public String getCallId() {
        return callId;
    }

    public CallStatus getCallStatus() {
        return callStatus;
    }

    public String getConferenceId() {
        return conferenceId;
    }

    public String getQueueId() {
        return queueId;
    }

    public Direction getDirection() {
        return direction;
    }
}
