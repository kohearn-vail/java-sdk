package com.vailsys.freeclimb.api;

/**
 * Base FreeClimb exception class off of which all other exceptions in the sDK
 * are based.
 */
public class FreeClimbException extends Exception {
	private final static String prefix = "FreeClimbException::";

	public FreeClimbException(String message) {
		super(prefix + message);
	}

	public FreeClimbException(Throwable cause) {
		super(prefix + cause.getMessage(), cause);
	}

	public FreeClimbException(String message, Throwable cause) {
		super(prefix + message, cause);
	}
}
