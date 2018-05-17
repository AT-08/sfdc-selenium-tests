Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    When I login to the application
    And I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME | test2 |

  Scenario: Edit account with all fields filled
    Given I can go to account section
    When I choose an account and press the edit button
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME   | test12 |
      | ACCOUNT_NUMBER | 12     |
      | ACCOUNT_SITE   | 15     |
      | TYPE           | Other  |
      | INDUSTRY       | Energy |
      | ANUAL_REVENUE  | 150    |
    Then I can verify the new account "test12"

  Scenario: Delete account
    Given I can go to account section
    When I choose an account and press the delete button
    Then I can verify that the account was deleted