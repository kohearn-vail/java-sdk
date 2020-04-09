Feature: ParticipantUpdateOptions

  Scenario: The ParticipantUpdateOptions constructor should ensure all the fields are null
    Given an empty ParticipantUpdateOptions object
    Then check that all ParticipantUpdateOptions fields are null

    Scenario: The ParticipantUpdateOptions getters and setters should work
      Given an empty ParticipantUpdateOptions object
      When talk is set to true in ParticipantUpdateOptions
      Then check that talk is true in ParticipantUpdateOptions
      When listen is set to false in ParticipantUpdateOptions
      Then check that listen is false in ParticipantUpdateOptions
