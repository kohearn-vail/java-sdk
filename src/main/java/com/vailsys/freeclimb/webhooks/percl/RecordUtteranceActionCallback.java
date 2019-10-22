package com.vailsys.freeclimb.webhooks.percl;

import com.vailsys.freeclimb.webhooks.FreeClimbRequest;
import com.vailsys.freeclimb.webhooks.StatusCallback;
import com.vailsys.freeclimb.api.FreeClimbJSONException;
import com.vailsys.freeclimb.api.FreeClimbException;
import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;
import com.vailsys.freeclimb.webhooks.VoiceRequest;

public class RecordUtteranceActionCallback extends VoiceRequest {
	private String recordingId;
	private String recordingUrl;
	private Integer recordingSize;
	private String recordingFormat;
	private Integer recordingDurationSec;
	private TermReason termReason;

	private RecordUtteranceActionCallback() {
	}

	public static RecordUtteranceActionCallback createFromJson(String jsonString) throws FreeClimbException {
		try {
			return gson.fromJson(jsonString, RecordUtteranceActionCallback.class);
		} catch (JsonIOException | JsonSyntaxException je) {
			throw new FreeClimbJSONException(je);
		}
	}

	public String getRecordingId() {
		return this.recordingId;
	}

	public String getRecordingUrl() {
		return this.recordingUrl;
	}

	public Integer getRecordingSize() {
		return this.recordingSize;
	}

	public String getRecordingFormat() {
		return this.recordingFormat;
	}

	public Integer getRecordingDurationSec() {
		return this.recordingDurationSec;
	}

	public TermReason getTermReason() {
		return this.termReason;
	}
}
