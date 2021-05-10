package com.vailsys.freeclimb.api;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;

public class FreeClimbClientTest {
	private FreeClimbClient client;

	@Given("^a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void makeFreeClimbClient(String credAccountId, String credApiKey) throws Throwable {
		this.client = new FreeClimbClient(credAccountId, credApiKey);
	}

	@Given("^a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void makeFreeClimbClientDiff(String credAccountId, String credApiKey, String accountId) throws Throwable {
		this.client = new FreeClimbClient(credAccountId, credApiKey, accountId);
	}

	@Then("^verify a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40})$")
	public void verifyFreeClimbClient(String credAccountId, String credApiKey) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredApiKey(), is(credApiKey));
	}

	@Then("^verify a FreeClimbClient with accountId (AC[0-9A-Fa-f]{40}) and authtoken ([0-9A-Fa-f]{40}) but using accountId (AC[0-9A-Fa-f]{40})$")
	public void verifyFreeClimbClientDiff(String credAccountId, String credApiKey, String accountId) {
		assertThat(this.client.getCredAccountId(), is(credAccountId));
		assertThat(this.client.getCredApiKey(), is(credApiKey));
		assertThat(this.client.getAccountId(), is(accountId));
	}
}
