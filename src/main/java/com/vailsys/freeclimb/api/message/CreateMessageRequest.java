package com.vailsys.freeclimb.api.message;

import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.Map;

/**
 * Represents the fields needed to create a new message on FreeClimb.
 *
 * @see com.vailsys.freeclimb.api.message.MessagesRequester
 */
class CreateMessageRequest {
	public String to;
	public String from;
	public String text;

	public MessageOptions options;

	/**
	 * Setup a new message creation payload using an applicationId.
	 *
	 * @param to      The number to message out to (DNIS). This can be any valid
	 *                phone number formatted in E.164 format.
	 * @param from    The number to message from (ANI). This must be a number
	 *                purchase from FreeClimb or a verified phone number owned by
	 *                the user.
	 * @param text    The {@code text} body of the message
	 * @param options Optional arguments that can be provided when creating a
	 *                message. See FreeClimb documentation for details.
	 */
	public CreateMessageRequest(String to, String from, String text, MessageOptions options) {
		this.to = to;
		this.from = from;
		this.text = text;

		this.options = options;
	}

	/**
	 * Convert this object into a JSON payload to use in FreeClimb message creation
	 * requests.
	 *
	 * @return JSON representation of this object.
	 */
	public String toJson() throws JsonIOException {
		JsonElement el = gson.toJsonTree(this);
		JsonObject obj = el.getAsJsonObject();
		if (obj.has("options")) {
			JsonObject options = obj.getAsJsonObject("options");
			obj.remove("options");
			for (Map.Entry<String, JsonElement> entry : options.entrySet()) {
				obj.add(entry.getKey(), entry.getValue());
			}
		}
		return obj.toString();
	}
}
