## Introduction

The FreeClimb Java SDK will allow you to easily use the FreeClimb API in a Java application.

[![Release](https://jitpack.io/v/FreeClimbAPI/java-sdk.svg)](https://jitpack.io/#FreeClimbAPI/java-sdk)
[![Build Status](https://travis-ci.com/FreeClimbAPI/java-sdk.svg?branch=master)](https://travis-ci.com/FreeClimbAPI/java-sdk)
[![Maintainability](https://api.codeclimate.com/v1/badges/5db37830ae23321e9150/maintainability)](https://codeclimate.com/github/FreeClimbAPI/java-sdk/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/5db37830ae23321e9150/test_coverage)](https://codeclimate.com/github/FreeClimbAPI/java-sdk/test_coverage)
[Docs](https://jitpack.io/com/github/freeclimbapi/java-sdk/latest/javadoc/)

### SDK Installation

To include the SDK in your build, follow the instructions on [Jitpack](https://jitpack.io/#FreeClimbAPI/java-sdk)

## Testing your Installation

Test the SDK is working by sending yourself a text message.

```java
public class Example {

    public static final String accountId = "ACXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";
    public static final String authToken = "your_auth_token";
    public static final String To = "your_phone_number";
    public static final String From = "a_free_climb_phone_number_in_your_account";

    public static void main(String[] args) throws FreeClimbException {
        FreeClimbClient client = new FreeClimbClient(accountId, authToken);

        client.messages.create(From, To, "Welcome to FreeClimb!");
    }
}
```

When you run this code you should get a text message.

### Running Unit Tests

You can run `gradle test` to run the full test suite.

You can also specify cucumber tags with the usual boolean inclusion / exclusion, specific feature files, or the line of the scenario or scenario outline example to run.

```bash
gradle -Dcucumber.options=src/test/resources/com/vailsys/freeclimb/api/call/Call.feature:5 test
```

```bash
gradle -Dcucumber.options="--tags @Calls" test
```

You can generate a Cobertura coverage report by running `gradle cobertura`. The report will be found at build/cobertura.

## Documentation

The [FreeClimb documentation](https://www.freeclimb.com/docs) has guides on [getting started](https://www.freeclimb.com/docs/getting-started/) with FreeClimb, as well as the [API reference](https://www.freeclimb.com/docs/api/), [PerCL reference](https://www.freeclimb.com/docs/percl/), and several useful [tutorials.](https://www.freeclimb.com/docs/tutorials/).

## Getting Help

If you are experiencing difficulties, contact our support team at [support@freeclimb.com](mailto:support@freeclimb.com).

## Dependencies

This SDK targets Java 7.

Import these dependencies:

- com.google.code.gson:gson:2.6.2
