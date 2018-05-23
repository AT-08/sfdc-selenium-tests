Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given Open Browser and launch the application enter the Username and Password and press login
    When I login to the application
    And I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME | Account to Modify |

  Scenario: Edit account with all fields filled
    Given I can go to account section
    When I choose an account and press the edit button
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME   | Account Modified |
      | ACCOUNT_NUMBER | 100              |
      | ACCOUNT_SITE   | 2                |
      | PARENT_ACCOUNT | test2            |
      | TYPE           | Prospect         |
      | INDUSTRY       | Agriculture      |
      | ANNUAL_REVENUE | 200              |
      | RATING         | Hot              |
      | PHONE          | 591591591        |
      | FAX            | 591591222        |
      | WEBSITE        | www.website.com  |
      | TICKER_SYMBOL  | ACC              |
      | OWNERSHIP      | Private          |
      | EMPLOYEES      | 10               |
      | SIC_CODE       | 200200200        |
    Then I can verify the new account "test12"

  Scenario: Delete account
    Given I can go to account section
    When I choose an account and press the delete button
    Then I can verify that the account was deleted