package com.vailsys.freeclimb.api;

public class APIRequesterModder {
	public static void changeFreeClimbUrl(APIRequester req, String newUrl) throws ThisIsABadIdeaException {
		req.setFreeClimbUrl(newUrl);
		throw new ThisIsABadIdeaException();
	}
}
