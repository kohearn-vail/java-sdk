package com.vailsys.freeclimb.api;

/**
 * This exception is thrown when the FreeClimb API responds with and HTTP error
 * code to some user request.
 */
public class FreeClimbErrorResponseException extends FreeClimbException {
	private FreeClimbError pe;

	/**
	 * @param status  The status code of the error.
	 * @param message The error message.
	 * @param code    The error code.
	 * @param info    Additional information about the error.
	 */
	public FreeClimbErrorResponseException(int status, String message, int code, String info) {
		super("ErrorResponse (" + status + ")::" + code + ":" + message);
		this.pe = new FreeClimbError(status, message, code, info);
	}

	/**
	 * @param pe The Error to wrap in a FreeClimbErrorResponseException.
	 */
	public FreeClimbErrorResponseException(FreeClimbError pe) {
		super("ErrorResponse (" + pe.getStatus() + ")::" + pe.getCode() + ":" + pe.getMessage());
		this.pe = pe;
	}

	/**
	 * @return an object representing the error payload returned from the FreeClimb
	 *         API
	 */
	public FreeClimbError getError() {
		return this.pe;
	}
}
