package com.vailsys.freeclimb.api.call;

import java.util.HashMap;
import java.lang.reflect.Type;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.FieldPosition;

import static com.vailsys.freeclimb.json.FreeClimbGson.FreeClimbDateFormat;
import static com.vailsys.freeclimb.json.FreeClimbGson.gson;

import com.google.gson.LongSerializationPolicy;
import com.google.gson.reflect.TypeToken;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class CallOptionsTest {

	CallOptions options;

	@Given("^An empty CallOptions object.$")
	public void createCallOptions() {
		this.options = new CallOptions();
	}

	@Then("^check that all fields are null.$")
	public void checkFieldsAreNull() {
		assertThat(this.options.getSendDigits(), nullValue());
		assertThat(this.options.getIfMachine(), nullValue());
		assertThat(this.options.getTimeout(), nullValue());
		assertThat(this.options.getPrivacyMode(), nullValue());
		assertThat(this.options.getApplicationId(), nullValue());
	}

	@Then("^check that setSendDigits\\(\\) and getSendDigits\\(\\) are setting and retrieving the correct value.$")
	public void checkSetGetSendDigits() {
		String digits = "2764*";
		this.options.setSendDigits(digits);
		assertThat(this.options.getSendDigits(), is(digits));
	}

	@Then("^check that setIfMachine\\(\\) and getIfMachine\\(\\) are setting and retrieving the correct value.$")
	public void checkSetGetIfMachine() {
		IfMachine ifMachine = IfMachine.CONTINUE;
		this.options.setIfMachine(ifMachine);
		assertThat(this.options.getIfMachine(), is(ifMachine));
	}

	@Then("^check that setTimeout\\(\\) and getTimeout\\(\\) are setting and retrieving the correct value.$")
	public void checkSetGetTimeout() {
		Integer timeout = 30;
		this.options.setTimeout(timeout);
		assertThat(this.options.getTimeout(), is(timeout));
	}

	@Then("^check that setParentCallId\\(\\) and getParentCallId\\(\\) are setting and retrieving the correct value.$")
	public void checkSetGetParentCallId() {
		String parentCallId = "CA0000000000000000000000000000000000000000";
		this.options.setParentCallId(parentCallId);
		assertThat(this.options.getParentCallId(), is(parentCallId));
	}

	@Then("^check that setPrivacyMode and getPrivacyMode are setting and retrieving the correct value.$")
	public void checkSetGetPrivacyMode() {
		this.options.setPrivacyMode(true);
		assertThat(this.options.getPrivacyMode(), is(true));
	}

	@Then("^check that setApplicationId and getApplicationId are setting and retrieving the correct value.$")
	public void checkSetGetApplicationId() {
		String applicationId = "AP0000000000000000000000000000000000000000";
		this.options.setApplicationId(applicationId);
		assertThat(this.options.getApplicationId(), is(applicationId));
	}
}
