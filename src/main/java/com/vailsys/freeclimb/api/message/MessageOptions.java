package com.vailsys.freeclimb.api.message;



/**
 * The class represents the common optional fields which can be passed in when
 * creating a Message.
 *
 * @see com.vailsys.freeclimb.api.message.MessagesRequester#create(String,String,String,MessageOptions)
 */
public class MessageOptions {
	/**
	 * The url that will be requested when the status of an outbound message
	 * changes.
	 */
	private String notificationUrl;

	/**
	 * Create an empty {@code MessageOptions} object. Set only values that are
	 * desired to be included in the request. Any unset fields will be ignored.
	 */
	public MessageOptions() {
		notificationUrl = null;
	}

	/**
	 * Sets the notificationUrl field.
	 *
	 * @param notificationUrl Value to which to set notificationUrl.
	 */
	public void setNotificationUrl(String notificationUrl) {
		this.notificationUrl = notificationUrl;
	}

	/**
	 * Retrieve the notificationUrl value.
	 *
	 * @return The notificationUrl value of the object.
	 */
	public String getNotificationUrl() {
		return this.notificationUrl;
	}

}
