package com.vailsys.freeclimb.percl;

import com.google.gson.annotations.SerializedName;

/**
 * This enum represents the predefined values for the {@code ifMachine} field
 * when creating a call. It is used to describe the desired behavior should
 * FreeClimb detect that the call was answered by an answering machine.
 */
public enum OutDialIfMachine {
	/**
	 * Tells FreeClimb to redirect the call if detecting that a machine has answered
	 * the call.
	 */
	@SerializedName("redirect")
	REDIRECT,
	/**
	 * Tells FreeClimb to hangup the call if detecting that a machine has answered
	 * the call.
	 */
	@SerializedName("hangup")
	HANGUP
}
