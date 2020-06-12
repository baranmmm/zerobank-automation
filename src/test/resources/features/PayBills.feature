@all
Feature: Pay Bills Features


  Scenario: Verifying Pay Bills title
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    Then the title of the Pay Bills page should be "Zero - Pay Bills"


  Scenario: Verifying SUCCESSFUL payment of a bill
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user should be able to create a successful pay operation
    Then payment successful message should be appeared


  Scenario: Verifying appearance of error message
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user leaves the amount empty
    Then "Please fill out this field." message should be appeared


  Scenario: Verifying appearance of error message
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user leaves the date empty
    Then "Please fill out this field." message should be appeared


  Scenario: Verifying Amount field doesn't accept alphabetical characters
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user enters alphabetical characters to Amount field
    Then the user should not be able to make a payment

  Scenario: Verifying Amount field doesn't accept special characters
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user enters special characters to Amount field
    Then the user should not be able to make a payment

  Scenario: Verifying date field doesn't accept alphabetical characters
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Pay Bills" tab
    When the user enters alphabetical characters to Date field
    Then the user should not be able to make a payment
