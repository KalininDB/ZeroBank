@AA
Feature: Checking Account Activity page

  Background:
    Given the user is on the login page
    When the users enters the correct credentials
    Then the user click on "Account Activity"

  Scenario: Check the elements of Account Activity page
    Then "Account Activity" page should have the title "Zero - Account activity"
    And In the Account drop	down default option should be "Savings"
    Then Account drop down should have the following options
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |