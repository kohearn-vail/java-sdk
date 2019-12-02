package com.vailsys.freeclimb.percl;

import java.util.LinkedList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;

public class RejectTest {

	Reject command;
	@Given("^a Reject with no reason$")
	public void createEmptyReject() {
		this.command = new Reject();
	}

	@Then("^check that the reason has no value$")
	public void checkReasonNull() {
		assertThat(this.command.getReason(), nullValue());
  }

  @Given("^a Reject with reason (.*)$")
	public void createReject(String reason) {
		this.command = new Reject(reason);
	}

	@Then("^check that the reason is (.*)$")
	public void checkReason(String reason) {
		assertThat(this.command.getReason(), is(reason));
  }
  
  @When("^the reason is set to (.*)$")
  public void setReason(String reason) throws Throwable {
      this.command.setReason(reason);
  }
}
