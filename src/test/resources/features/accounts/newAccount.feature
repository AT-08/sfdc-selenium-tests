Feature: Create a new account

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME | test1 |
    Then I can verify the new account "test1"

  Scenario: Create a new account with all fields filled
    Given I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME   | test2       |
      | ACCOUNT_NUMBER | 1           |
      | ACCOUNT_SITE   | 2           |
      | TYPE           | Prospect    |
      | INDUSTRY       | Agriculture |
      | ANUAL_REVENUE  | 200         |
    Then I can verify the new account "test2"