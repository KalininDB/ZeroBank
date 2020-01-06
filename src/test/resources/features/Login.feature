
Feature: Autorized user should be able login

  Background:
    Given the user is on the login page
    Then the title should contains Log in
@Login
    Scenario: Login as autorized users
      When the users enters the correct credentials
      Then the user should be able to log in
      Then Account summary should be displayed

    Scenario: Login with wrong username
     When the user enter invalid username and valid password
     Then the user should not be able to login
     And Login and or password are wrong should be displayed

    Scenario: Login with wrong password
      When the user enter invalid password and valid username
      Then the user should not be able to login
      And Login and or password are wrong should be displayed

    Scenario: Login with blank username
      When the user enter valid password and blank username
      Then the user should not be able to login
      And Login and or password are wrong should be displayed

    Scenario: Login with blank password
      When the user enter valid username and blank password
      Then the user should not be able to login
      And Login and or password are wrong should be displayed






