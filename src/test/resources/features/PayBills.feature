@PB
Feature: Pay Bills page

  Background:
    When the user is on the login page
    Then the users enters the correct credentials
    Then the user click on "Pay Bills"

  Scenario: Check the title page Pay Bills
    Then "Pay Bills" page should have the title "Zero - Pay Bills"

  Scenario: Check payment message after correct payment operation
    Given the user fill up all fields for payment
    Then Message Should be "The payment was successfully submitted."

  Scenario: Check payment message with keep Date field blank
    Given fill up all fields, exclude "Date" field
    Then Failed Message should be "Please fill out this field."

  Scenario: Check payment message with keep Amount field blank
    Given fill up all fields, exclude "Amount" field
    Then Failed Message should be "Please fill out this field."

  Scenario: Check payment message using words for Date field
      Given fill up all fields for Data field use alphabetical, Data field must be empty

  Scenario: Check payment message using words for Amount field
    Given fill up all fields for Amount field use alphabetical, Amount field must be empty

