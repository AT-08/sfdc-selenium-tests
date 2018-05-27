Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed
    And I can go to "ACCOUNT" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | ACCOUNT_NAME | Account to Modify |

  Scenario: Edit account with all fields filled
    When I click on edit button to new account created
    And I can fill the fields of Account and press the save button
      | ACCOUNT_NAME   | Account Modified  |
      | ACCOUNT_NUMBER | 100               |
      | ACCOUNT_SITE   | 2                 |
      | PARENT_ACCOUNT | Account to Modify |
      | TYPE           | Prospect          |
      | INDUSTRY       | Agriculture       |
      | ANNUAL_REVENUE | 200               |
      | RATING         | Hot               |
      | PHONE          | 591591591         |
      | FAX            | 591591222         |
      | WEBSITE        | www.website.com   |
      | TICKER_SYMBOL  | ACC               |
      | OWNERSHIP      | Private           |
      | EMPLOYEES      | 10                |
      | SIC_CODE       | 200200200         |
    Then I can verify if "Account to Modify" has been created

  Scenario: Delete account
    Given I can go to "ACCOUNT" Section
    When I choose an account and press the delete button
    Then I can verify that the account was deleted