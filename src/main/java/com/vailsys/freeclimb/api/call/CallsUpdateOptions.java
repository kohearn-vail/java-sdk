package com.vailsys.freeclimb.api.call;

import com.vailsys.freeclimb.api.CommonFields;

/**
 * The class represents the optional fields which can be passed in when updating
 * a Call.
 *
 * @see com.vailsys.freeclimb.api.call.CallsRequester#update(String,
 *      CallsUpdateOptions)
 */
public class CallsUpdateOptions extends CommonFields {
	private CallStatus status;

	public CallStatus getStatus() {
		return this.status;
	}

	public void setStatus(CallStatus status) {
		this.status = status;
	}

}
