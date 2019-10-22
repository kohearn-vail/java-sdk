package com.vailsys.freeclimb.percl;

import java.util.LinkedList;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.Gson;

/**
 * The PerCLScript class represents a PerCL script to be returned to the
 * FreeClimb servers in FreeClimb applications. PerCLScript is a LinkedList of
 * PerCLCommands.
 *
 * @see java.util.LinkedList
 */
public class PerCLScript extends LinkedList<PerCLCommand> {
	/**
	 * Initializes an empty script.
	 */
	public PerCLScript() {
		super();
	}

	/**
	 * Converts the script into a JSON array of the contained PerCL commands.
	 *
	 * @see com.google.gson.Gson
	 * @return The PerCL script as a JSON string.
	 */
	public String toJson() {
		return gson.toJson(this);
	}
}
