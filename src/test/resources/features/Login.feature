@all
Feature: Users should be able to login

  Scenario:User should be able to login with VALID credentials
    Given the user is on the login page
    When the user enters valid credential
    Then the user should be on Account Summary page


  Scenario:User should be able to login with INVALID username
    Given the user is on the login page
    When the user enters invalid username
    Then the user should see the "Login and/or password are wrong." message

  Scenario:User should be able to login with INVALID password
    Given the user is on the login page
    When the user enters invalid password
    Then the user should see the "Login and/or password are wrong." message

  Scenario:User should be able to login with INVALID username and password
    Given the user is on the login page
    When the user enters invalid username and password
    Then the user should see the "Login and/or password are wrong." message

  Scenario:User should not be able to login by leaving username and password BLANK
    Given the user is on the login page
    When the user leaves the username and password blank
    Then the user should see the "Login and/or password are wrong." message