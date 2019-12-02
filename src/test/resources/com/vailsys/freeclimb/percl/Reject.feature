Feature: Reject

	Scenario: Create a default Reject
		Given a Reject with no reason
		Then check that the reason has no value

  Scenario: Create a Reject with reason
		Given a Reject with reason not a bears fan
		Then check that the reason is not a bears fan

	Scenario: Setting and checking reason field
		Given a Reject with no reason
		When the reason is set to not a bears fan
		Then check that the reason is not a bears fan
