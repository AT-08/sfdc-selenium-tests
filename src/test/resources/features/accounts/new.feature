Feature: Create a new account

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | accountName     | test1           |
    Then a new account is created
      | accountName     | test1           |

  Scenario: Create a new account with first 4 fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | accountName     | test2           |
      | parentAccount   | Account 88      |
      | accountNumber   | 1               |
      | accountSite     | 2               |
    Then a new account is created
      | accountName     | test2           |

  Scenario: Create a new account with last 2 fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | accountName     | test3           |
      | industry        | Agriculture     |
      | anuualRevenue   | 200             |
    Then a new account is created
      | accountName     | test3           |

  Scenario: Create a new account with all fields filled
    Given Go to accounts section
    When I press new account button a new account form is displayed
    And I fill the fields and press the save button
      | accountName     | test4           |
      | parentAccount   | Account 88      |
      | accountNumber   | 1               |
      | accountSite     | 2               |
      | type            | Prospect        |
      | industry        | Agriculture     |
      | anuualRevenue   | 200             |
    Then a new account is created
      | accountName     | test4           |