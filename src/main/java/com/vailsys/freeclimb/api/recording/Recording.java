package com.vailsys.freeclimb.api.recording;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import java.util.Date;
import java.util.HashMap;

import com.vailsys.freeclimb.api.FreeClimbCommon;
import com.vailsys.freeclimb.api.FreeClimbJSONException;

import com.google.gson.annotations.SerializedName;
import com.google.gson.JsonSyntaxException;

/**
 * This class represents a FreeClimb Recording instance. Recording objects are
 * created by the SDK whenever a recording instance would be returned by the
 * API; these primarily come from a
 * {@link com.vailsys.freeclimb.api.recording.RecordingsRequester} inside a
 * {@link com.vailsys.freeclimb.api.FreeClimbClient} instance.<br>
 * <br>
 * Recordings are immutable and intended only to be used to read information
 * returned from the API in a language accessible way.
 *
 * @see com.vailsys.freeclimb.api.recording.RecordingsRequester
 * @see com.vailsys.freeclimb.api.FreeClimbClient
 */
public class Recording extends FreeClimbCommon {
	private String recordingId;
	private String accountId;
	private String callId;
	private Integer durationSec;
	private String conferenceId;

	public String getRecordingId() {
		return this.recordingId;
	}

	public String getAccountId() {
		return this.accountId;
	}

	public String getCallId() {
		return this.callId;
	}

	public Integer getDurationSec() {
		return this.durationSec;
	}

	public String getConferenceId() {
		return this.conferenceId;
	}

	public static Recording fromJson(String json) throws FreeClimbJSONException {
		try {
			return gson.fromJson(json, Recording.class);
		} catch (JsonSyntaxException jse) {
			throw new FreeClimbJSONException(jse);
		}
	}

	public String toString() {
		return gson.toJson(this);
	}

	public boolean equals(Recording that) {
		return super.equals(that) && ((this.recordingId == null && that.recordingId == null)
				|| (this.recordingId != null && that.recordingId != null && this.recordingId.equals(that.recordingId)))
				&& ((this.accountId == null && that.accountId == null)
						|| (this.accountId != null && that.accountId != null && this.accountId.equals(that.accountId)))
				&& ((this.callId == null && that.callId == null)
						|| (this.callId != null && that.callId != null && this.callId.equals(that.callId)))
				&& ((this.durationSec == null && that.durationSec == null) || (this.durationSec != null
						&& that.durationSec != null && this.durationSec.equals(that.durationSec)))
				&& ((this.conferenceId == null && that.conferenceId == null) || (this.conferenceId != null
						&& that.conferenceId != null && this.conferenceId.equals(that.conferenceId)));
	}
}
