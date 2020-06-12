@all
Feature: Account Activity Features


  Scenario: Verifying Account Activity title
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Account Activity" tab
    Then the title of the Account Activity page should be "Zero - Account Activity"


  Scenario: Verifying Account Account dropdown menu options
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Account Activity" tab
    Then the default option of Account dropdown menu should be Savings
    Then Account dropdown menu options should be as following
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |


  Scenario: Verifying Show Transaction table columns
    Given the user is on the login page
    When the user enters valid credential
    When the user navigates to "Account Activity" tab
    Then Show Transaction table should contain following columns
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |