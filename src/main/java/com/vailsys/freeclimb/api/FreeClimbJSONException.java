package com.vailsys.freeclimb.api;

/**
 * Raised when there is a problem interpretting JSON or converting an object to
 * JSON.
 */
public class FreeClimbJSONException extends FreeClimbException {
	private final static String prefix = "JSONException::";

	public FreeClimbJSONException(String message) {
		super(prefix + message);
	}

	public FreeClimbJSONException(Throwable cause) {
		super(prefix + cause.getMessage(), cause);
	}

	public FreeClimbJSONException(String message, Throwable cause) {
		super(prefix + message, cause);
	}
}
