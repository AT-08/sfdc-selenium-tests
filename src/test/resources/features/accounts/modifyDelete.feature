Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    When I login to the application
    Then I create a new account
      | accountName | account modify delete |

  Scenario: Modify an existing account
    Given Go to accounts section
    When I choose an account from recent accounts and I execute action
    And I edit the account name field and I press the save button
      | accountName | modify |
    Then a new account is created
      | accountName | modify |

  Scenario: Delete an existing account
    Given Go to accounts section
    When I choose an account from recent accounts and I execute action
    And I click on OK
    Then the system deletes the account