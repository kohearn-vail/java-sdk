package com.vailsys.freeclimb.api;

/**
 * This exception is thrown when something internal is broken in the SDK. If an
 * SDK user recieves this exception it means somthing in the SDK itself is
 * broken. User actions should never trigger this exception. It is only raised
 * by an SDK developer breaking something within the SDK.
 */
public class FreeClimbSDKException extends FreeClimbException {
	private static String prefix = "SDKInternal::";
	private static String suffix = " If receieving this error, please file a bug report.";

	public FreeClimbSDKException(String message) {
		super(prefix + message + suffix);
	}

	public FreeClimbSDKException(Throwable cause) {
		super(prefix + cause.getMessage() + suffix, cause);
	}

	public FreeClimbSDKException(String message, Throwable cause) {
		super(prefix + message + suffix, cause);
	}
}
