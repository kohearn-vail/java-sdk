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
	private String credAuthToken;
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
	 * @param credAuthToken The Auth Token to use in your credentials for the
	 *                      FreeClimb API. This should be the matching Auth Token to
	 *                      the credAccountId parameter.
	 * @param accountId     The Account ID of the account you want to act as. This
	 *                      should either be the same Account ID ass credAccountId
	 *                      or the id of a sub-account to the credAccountId's
	 *                      account.
	 * @see #FreeClimbClient(String, String)
	 * @throws FreeClimbException when any of the requesters throws a
	 *                            FreeClimbException.
	 */
	public FreeClimbClient(String credAccountId, String credAuthToken, String accountId) throws FreeClimbException {
		this.credAccountId = credAccountId;
		this.credAuthToken = credAuthToken;
		this.accountId = accountId;

		this.accounts = new AccountRequester(credAccountId, credAuthToken, accountId);
		this.recordings = new RecordingsRequester(credAccountId, credAuthToken, accountId);
		this.calls = new CallsRequester(credAccountId, credAuthToken, accountId);
		this.conferences = new ConferencesRequester(credAccountId, credAuthToken, accountId);
		this.logs = new LogRequester(credAccountId, credAuthToken, accountId);
		this.available = new AvailablePhoneNumberRequester(credAccountId, credAuthToken, accountId);
		this.calling = new CallingNumberRequester(credAccountId, credAuthToken, accountId);
		this.incoming = new IncomingPhoneNumberRequester(credAccountId, credAuthToken, accountId);
		this.queues = new QueuesRequester(credAccountId, credAuthToken, accountId);
		this.applications = new ApplicationsRequester(credAccountId, credAuthToken, accountId);
		this.messages = new MessagesRequester(credAccountId, credAuthToken, accountId);
	}

	/**
	 * This constructor allows one to create a FreeClimbClient that authenticates
	 * with one set of credentials and acts as that account.
	 *
	 * This Constructor is a shortcut for calling
	 * {@code FreeClimbClient(credAccountId, credAuthToken, credAccountId)}.
	 *
	 * @param credAccountId The Account ID to use in your credentials for the
	 *                      FreeClimb API.
	 * @param credAuthToken The Auth Token to use in your credentials for the
	 *                      FreeClimb API. This should be the matching Auth Token to
	 *                      the credAccountId parameter.
	 * @see #FreeClimbClient(String, String, String)
	 * @throws FreeClimbException when any of the requesters throws a
	 *                            FreeClimbException.
	 */
	public FreeClimbClient(String credAccountId, String credAuthToken) throws FreeClimbException {
		this(credAccountId, credAuthToken, credAccountId);
	}

	/**
	 * @return the Account ID being used to authenticate with the API
	 */
	public String getCredAccountId() {
		return credAccountId;
	}

	/**
	 * @return the Auth Token being used to authenticate with the API
	 */
	public String getCredAuthToken() {
		return credAuthToken;
	}

	/**
	 * @return the Account ID of the account that this client is acting as.
	 */
	public String getAccountId() {
		return accountId;
	}
}
