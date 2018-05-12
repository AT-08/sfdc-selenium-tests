Feature: Accounts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the account name field and press the save button
    Then a new account is created

  Scenario: Modify an existing account
    Given Go to accounts section
    When I choose an account from recent accounts and I click on Edit account
    And I edit the account name field and I press the save button
    Then a new account is created

  Scenario: Delete an existing account
    Given Go to accounts section
    When I choose an account from recent accounts and I click on Delete account
    And I click on OK
    Then the system delete the account




