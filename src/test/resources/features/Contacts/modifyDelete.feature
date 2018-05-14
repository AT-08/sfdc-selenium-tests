Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then login to the application

  Scenario: Modify an existing account
    Given Go to accounts section
    When I choose an account from recent accounts and I click on Edit account
    And I edit the account name field and I press the save button
    Then a new account is created

  Scenario: Delete an existing account
    Given Go to accounts section
    When I choose last account from recent accounts and I click on Delete account
    And I click on OK
    Then the system delete the account