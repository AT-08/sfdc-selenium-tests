Feature: Create a new account

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | ACCOUNT_NAME | test1 |
    Then a new account is created "test1"

  Scenario: Create a new account with first 4 fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | ACCOUNT_NAME   | test2      |
      | PARENT_ACCOUNT | Account 88 |
      | ACCOUNT_NUMBER | 1          |
      | ACCOUNT_SITE   | 2          |
    Then a new account is created "test2"

  Scenario: Create a new account with last 2 fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | ACCOUNT_NAME  | test3       |
      | INDUSTRY      | Agriculture |
      | ANUAL_REVENUE | 200         |
    Then a new account is created "test3"

  Scenario: Create a new account with all fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | ACCOUNT_NAME   | test4       |
      | PARENT_ACCOUNT | Account 88  |
      | ACCOUNT_NUMBER | 1           |
      | ACCOUNT_SITE   | 2           |
      | TYPE           | Prospect    |
      | INDUSTRY       | Agriculture |
      | ANUAL_REVENUE  | 200         |
    Then a new account is created "test4"