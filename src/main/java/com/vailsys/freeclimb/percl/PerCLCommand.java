package com.vailsys.freeclimb.percl;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import java.util.HashMap;

/**
 * The PerCLCommand class is a base class from which classes representing
 * various PerCL commands can be built.
 */
public class PerCLCommand {
	/**
	 * Convert this command into a JSON string.
	 *
	 * @see com.vailsys.freeclimb.api.FreeClimbCommon
	 * @return The PerCLCommand as a JSON string.
	 */
	public String toJson() {
		return gson.toJson(this, PerCLCommand.class);
	}
}
