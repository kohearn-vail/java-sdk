package com.vailsys.freeclimb.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class FreeClimbClientTest {
	private FreeClimbClient client;

	@Given("^a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void makeFreeClimbClient(String credAccountId, String credAuthToken) throws Throwable {
		this.client = new FreeClimbClient(credAccountId, credAuthToken);
	}

	@Given("^a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void makeFreeClimbClientDiff(String credAccountId, String credAuthToken, String accountId) throws Throwable {
		this.client = new FreeClimbClient(credAccountId, credAuthToken, accountId);
	}

	@Then("^verify a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void verifyFreeClimbClient(String credAccountId, String credAuthToken) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredAuthToken(), is(credAuthToken));
	}

	@Then("^verify a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void verifyFreeClimbClientDiff(String credAccountId, String credAuthToken, String accountId) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredAuthToken(), is(credAuthToken));
		assertThat(this.client.getAccountId(), is(accountId));
	}
}
