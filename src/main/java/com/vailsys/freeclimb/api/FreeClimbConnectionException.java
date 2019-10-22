package com.vailsys.freeclimb.api;

/**
 * This exception is thrown when the SDK runs into problems with establishing a
 * connection with the FreeClimb API.
 */
public class FreeClimbConnectionException extends FreeClimbException {
	private final static String prefix = "APIConnection::";

	public FreeClimbConnectionException(String message) {
		super(prefix + message);
	}

	public FreeClimbConnectionException(Throwable cause) {
		super(prefix + cause.getMessage(), cause);
	}

	public FreeClimbConnectionException(String message, Throwable cause) {
		super(prefix + message, cause);
	}
}
