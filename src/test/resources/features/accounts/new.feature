Feature: Create a new account

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the account name field and press the save button
    Then a new account is created

  Scenario: Create a new account with all fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | accountName     | test1           |
      | parentAccount   | Account 88      |
      | accountNumber   | 1               |
      | accountSite     | 2               |
      | type            | Prospect        |
      | industry        | Agriculture     |
      | anuualRevenue   | 200             |
    Then a new account is created
      | accountName     | test1           |