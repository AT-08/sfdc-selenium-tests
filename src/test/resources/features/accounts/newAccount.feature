Feature: Create a new account

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new account with only obligatory fields filled
    Given I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME | Account with only obligatory fields filled |
    Then I can verify the new account "Account with only obligatory fields filled"

  Scenario: Create a new account with all fields filled
    Given I can go to account section
    And I can create a new account
    And I can create a new account fill the fields and press the save button
      | ACCOUNT_NAME   | Account with all fields filled |
      | ACCOUNT_NUMBER | 100                            |
      | ACCOUNT_SITE   | 2                              |
      | PARENT_ACCOUNT | test2                          |
      | TYPE           | Prospect                       |
      | INDUSTRY       | Agriculture                    |
      | ANUAL_REVENUE  | 200                            |
      | RATING         | Hot                            |
      | PHONE          | 591591591                      |
      | FAX            | 591591222                      |
      | WEBSITE        | www.website.com                |
      | TICKER_SYMBOL  | ACC                            |
      | OWNERSHIP      | Public                         |
      | EMPLOYEES      | 10                             |
      | SIC_CODE       | 200200200                      |

    Then I can verify the new account "Account with all fields filled"