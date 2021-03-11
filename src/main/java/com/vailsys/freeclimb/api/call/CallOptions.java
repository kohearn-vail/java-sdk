package com.vailsys.freeclimb.api.call;



/**
 * The class represents the common optional fields which can be passed in when
 * creating a Call.
 *
 * @see com.vailsys.freeclimb.api.call.CallsRequester#create(String,String,CallOptions)
 */
public class CallOptions {
	/**
	 * A string of keys to dial after connecting to the number. Refer to SendDigits
	 * PerCL command for the format of the digits string.
	 */
	private String sendDigits;
	/**
	 * Indicates what to do if FreeClimb detects that the call is answered by an
	 * answering machine.
	 *
	 * @see com.vailsys.freeclimb.api.call.IfMachine
	 */
	private IfMachine ifMachine;
	/**
	 * Time, in seconds, to wait before assuming there is no answer and hanging up
	 * the call.
	 */
	private Integer timeout;
	/**
	 * The callId of the call that created this call (if one exists). Required if no `applicationId` or `callConnectUrl` has been provided.
	 */
	private String parentCallId;

	/**
	 * Parameter privacyMode will not log the text as required by PCI compliance.
	 */
	private Boolean privacyMode;

	/**
	 * The applicationId for the registered FreeClimb application which should
	 * handle this call. Required if no `parentCallId` or `callConnectUrl` has been provided.
	 */
	private String applicationId;

	/**
	 * Create an empty {@code CallOptions} object. Set only values that are desired
	 * to be included in the request. Any unset fields will be ignored.
	 */
	public CallOptions() {
		sendDigits = null;
		ifMachine = null;
		timeout = null;
		parentCallId = null;
		privacyMode = null;
		applicationId = null;
	}

	/**
	 * Sets the sendDigits field.
	 * 
	 * @param sendDigits Value to which to set sendDigits.
	 */
	public void setSendDigits(String sendDigits) {
		this.sendDigits = sendDigits;
	}

	/**
	 * Sets the ifMachine field.
	 * 
	 * @param ifMachine Value to which to set ifMachine.
	 */
	public void setIfMachine(IfMachine ifMachine) {
		this.ifMachine = ifMachine;
	}

	/**
	 * Sets the timeout field.
	 * 
	 * @param timeout Value to which to set timeout.
	 */
	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	/**
	 * Sets the parentCallId field.
	 *
	 * @param parentCallId Value to which to set parentCallId.
	 */
	public void setParentCallId(String parentCallId) {
		this.parentCallId = parentCallId;
	}

	/**
	 * Sets the privacyMode field.
	 *
	 * @param privacyMode Value to which to set privacyMode.
	 */
	public void setPrivacyMode(Boolean privacyMode) {
		this.privacyMode = privacyMode;
	}

	/**
	 * Sets the applicationId field.
	 *
	 * @param applicationId Value to which to set applicationId.
	 */
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	
	/**
	 * Retrieve the sendDigits value.
	 * 
	 * @return The sendDigits value of the object.
	 */
	public String getSendDigits() {
		return this.sendDigits;
	}

	/**
	 * Retrieve the ifMachine value.
	 * 
	 * @return The ifMachine value of the object.
	 *
	 * @see com.vailsys.freeclimb.api.call.IfMachine
	 */
	public IfMachine getIfMachine() {
		return this.ifMachine;
	}

	/**
	 * Retrieve the timeout value.
	 * 
	 * @return The timeout value of the object.
	 */
	public Integer getTimeout() {
		return this.timeout;
	}

	/**
	 * Retrieve the parentCallId value.
	 *
	 * @return The parentCallId value of the object.
	 */
	public String getParentCallId() {
		return this.parentCallId;
	}

	/**
	 * Retrieve the privacyMode value.
	 * 
	 * @return The privacyMode value of the object.
	 */
	public Boolean getPrivacyMode() {
		return this.privacyMode;
	}

	/**
	 * Retrieve the applicationId value.
	 *
	 * @return The applicationId value of the object.
	 */
	public String getApplicationId() {
		return this.applicationId;
	}
}
