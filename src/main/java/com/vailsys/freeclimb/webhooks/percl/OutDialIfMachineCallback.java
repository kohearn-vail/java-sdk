package com.vailsys.freeclimb.webhooks.percl;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

public class OutDialIfMachineCallback extends VoiceRequest {
    private MachineType machineType;
    private String parentCallId;

    private OutDialIfMachineCallback() {
    }

    public static OutDialIfMachineCallback createFromJson(String jsonString) throws FreeClimbException {
        try {
            return gson.fromJson(jsonString, OutDialIfMachineCallback.class);
        } catch (JsonIOException | JsonSyntaxException je) {
            throw new FreeClimbJSONException(je);
        }
    }

    public MachineType getMachineType() {
        return machineType;
    }

    public String getParentCallId() {
        return parentCallId;
    }
}
