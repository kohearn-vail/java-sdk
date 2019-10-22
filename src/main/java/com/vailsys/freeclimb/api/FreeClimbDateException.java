package com.vailsys.freeclimb.api;

/**
 * Thrown by FreeClimb SDK componenets when they fail to parse a date string.
 */
public class FreeClimbDateException extends FreeClimbException {
	/**
	 * @param date  The offending date string
	 * @param index The index in the string where the first problem is noticed.
	 */
	public FreeClimbDateException(String date, int index) {
		super("Poorly formatted date::`" + date.substring(0, index) + ">>>>" + date.charAt(index) + "<<<<"
				+ date.substring(index + 1) + "`");
	}
}
