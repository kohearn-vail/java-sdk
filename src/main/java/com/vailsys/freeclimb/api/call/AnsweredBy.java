package com.vailsys.freeclimb.api.call;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the various possible predefined values of the
 * {@code answeredBy} field inside a FreeClimb Call instance. It indicates what
 * FreeClimb identified as having answered the call. See FreeClimb documentation
 * on Calls to understand this field in more detail.
 */
public enum AnsweredBy {
	/**
	 * This value represents a call that was answered in a way that FreeClimb could
	 * not determine. This is marked in the JSON representation of a Call instance
	 * that comes from the API as {@code
	 * ""} (an empty string).
	 */
	@SerializedName("")
	NONE,
	/**
	 * This value represents that FreeClimb detected that the call was answered by
	 * an answering machine. This is marked in the JSON representation of a Call
	 * instance that comes from the API as {@code
	 * "machine"}.
	 */
	@SerializedName("machine")
	MACHINE,
	/**
	 * This value represents that FreeClimb detected that a human answered the call.
	 * This is marked in the JSON representation of a Call instance that comes from
	 * the API as {@code "human"}.
	 */
	@SerializedName("human")
	HUMAN
}
