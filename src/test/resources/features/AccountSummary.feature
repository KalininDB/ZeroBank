@AccountSummary
Feature: Check the Account summary page

  Background:
    Given the user is on the login page
    Then the users enters the correct credentials
@AS
  Scenario: check the title of page Account summary
    Then the title should be "Zero – Account summary"

@AS
    Scenario: check the account types
      Then Credit Accounts table must have columns:
        |Account|
        |Credit Card|
        |Balance|
      When Account summary page should have to following account types:
    |Cash Accounts|
    |Investment Accounts|
    |Credit Accounts|
    |Loan Accounts|
