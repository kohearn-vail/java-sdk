package com.vailsys.freeclimb.api;

import com.vailsys.freeclimb.api.account.AccountRequester;
import com.vailsys.freeclimb.api.application.ApplicationsRequester;
import com.vailsys.freeclimb.api.conference.ConferencesRequester;
import com.vailsys.freeclimb.api.log.LogRequester;
import com.vailsys.freeclimb.api.message.MessagesRequester;
import com.vailsys.freeclimb.api.phoneNumber.AvailablePhoneNumberRequester;
import com.vailsys.freeclimb.api.phoneNumber.CallingNumberRequester;
import com.vailsys.freeclimb.api.phoneNumber.IncomingPhoneNumberRequester;
import com.vailsys.freeclimb.api.queue.QueuesRequester;
import com.vailsys.freeclimb.api.recording.RecordingsRequester;
import com.vailsys.freeclimb.api.call.CallsRequester;

/**
 * The FreeClimbClient is the main way within the SDK to interact with the
 * FreeClimb API. After creating a FreeClimbClient the user can any of it's many
 * APIRequesters to make requests to the API.
 */
public class FreeClimbClient {
	private String credAccountId;
	private String credApiKey;
	private String accountId;

	public AccountRequester accounts;
	public RecordingsRequester recordings;
	public CallsRequester calls;
	public ConferencesRequester conferences;
	public LogRequester logs;
	public AvailablePhoneNumberRequester available;
	public CallingNumberRequester calling;
	public IncomingPhoneNumberRequester incoming;
	public QueuesRequester queues;
	public ApplicationsRequester applications;
	public MessagesRequester messages;

	/**
	 * This constructor allows one to create a FreeClimbClient that authenticates
	 * with one set of credentials but acts as a second account (i.e. a sub
	 * account).
	 *
	 * @param credAccountId The Account ID to use in your credentials for the
	 *                      FreeClimb API.
	 * @param credApiKey The API key to use in your credentials for the
	 *                      FreeClimb API. This should be the matching API key to
	 *                      the credAccountId parameter.
	 * @param accountId     The Account ID of the account you want to act as. This
	 *                      should either be the same Account ID ass credAccountId
	 *                      or the id of a sub-account to the credAccountId's
	 *                      account.
	 * @see #FreeClimbClient(String, String)
	 * @throws FreeClimbException when any of the requesters throws a
	 *                            FreeClimbException.
	 */
	public FreeClimbClient(String credAccountId, String credApiKey, String accountId) throws FreeClimbException {
		this.credAccountId = credAccountId;
		this.credApiKey = credApiKey;
		this.accountId = accountId;

		this.accounts = new AccountRequester(credAccountId, credApiKey, accountId);
		this.recordings = new RecordingsRequester(credAccountId, credApiKey, accountId);
		this.calls = new CallsRequester(credAccountId, credApiKey, accountId);
		this.conferences = new ConferencesRequester(credAccountId, credApiKey, accountId);
		this.logs = new LogRequester(credAccountId, credApiKey, accountId);
		this.available = new AvailablePhoneNumberRequester(credAccountId, credApiKey, accountId);
		this.calling = new CallingNumberRequester(credAccountId, credApiKey, accountId);
		this.incoming = new IncomingPhoneNumberRequester(credAccountId, credApiKey, accountId);
		this.queues = new QueuesRequester(credAccountId, credApiKey, accountId);
		this.applications = new ApplicationsRequester(credAccountId, credApiKey, accountId);
		this.messages = new MessagesRequester(credAccountId, credApiKey, accountId);
	}

	/**
	 * This constructor allows one to create a FreeClimbClient that authenticates
	 * with one set of credentials and acts as that account.
	 *
	 * This Constructor is a shortcut for calling
	 * {@code FreeClimbClient(credAccountId, credApiKey, credAccountId)}.
	 *
	 * @param credAccountId The Account ID to use in your credentials for the
	 *                      FreeClimb API.
	 * @param credApiKey The API key to use in your credentials for the
	 *                      FreeClimb API. This should be the matching API key to
	 *                      the credAccountId parameter.
	 * @see #FreeClimbClient(String, String, String)
	 * @throws FreeClimbException when any of the requesters throws a
	 *                            FreeClimbException.
	 */
	public FreeClimbClient(String credAccountId, String credApiKey) throws FreeClimbException {
		this(credAccountId, credApiKey, credAccountId);
	}

	/**
	 * @return the Account ID being used to authenticate with the API
	 */
	public String getCredAccountId() {
		return credAccountId;
	}

	/**
	 * @return the API key being used to authenticate with the API
	 */
	public String getCredApiKey() {
		return credApiKey;
	}

	/**
	 * @return the Account ID of the account that this client is acting as.
	 */
	public String getAccountId() {
		return accountId;
	}
}
