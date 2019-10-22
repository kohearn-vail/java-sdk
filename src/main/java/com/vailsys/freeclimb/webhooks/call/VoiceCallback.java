package com.vailsys.freeclimb.webhooks.call;

import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.api.FreeClimbException;
import com.vailsys.freeclimb.api.call.CallStatus;
import com.vailsys.freeclimb.api.call.AnsweredBy;
import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

public class VoiceCallback extends VoiceRequest {
	private CallStatus dialCallStatus;
	private AnsweredBy answeredBy;

	private VoiceCallback() {
	}

	public static VoiceCallback createFromJson(String jsonString) throws FreeClimbException {
		try {
			return gson.fromJson(jsonString, VoiceCallback.class);
		} catch (JsonIOException jioe) {
			throw new FreeClimbJSONException(jioe);
		} catch (JsonSyntaxException jse) {
			throw new FreeClimbJSONException(jse);
		}
	}

	public CallStatus getDialCallStatus() {
		return this.dialCallStatus;
	}

	public AnsweredBy getAnsweredBy() {
		return this.answeredBy;
	}

}
