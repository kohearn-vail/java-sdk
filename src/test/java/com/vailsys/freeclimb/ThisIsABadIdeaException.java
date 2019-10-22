package com.vailsys.freeclimb.api;

public class ThisIsABadIdeaException extends FreeClimbException {
	public ThisIsABadIdeaException() {
		super("I recoginise that I shouldn't be using the thing that threw this exception, but I did it anyway.");
	}
}
