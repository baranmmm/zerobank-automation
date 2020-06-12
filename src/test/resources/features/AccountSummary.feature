@all
Feature: Account Summary features


  Scenario: Verifying Account Summary title
    Given the user is on the login page
    When the user enters valid credential
    Then the title of the Account Summary page should be "Zero - Account Summary"


  Scenario: Verifying Account Summary subMenu options
    Given the user is on the login page
    When the user enters valid credential
    Then subMenu options should be as following:
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |


  Scenario: Verifying Account Summary subMenu table columns
    Given the user is on the login page
    When the user enters valid credential
    Then "Credit Accounts" subMenu table's columns should be as following:
      | Account     |
      | Credit Card |
      | Balance     |

