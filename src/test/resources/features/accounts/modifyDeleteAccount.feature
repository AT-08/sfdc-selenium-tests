Feature: Modify and delete a previous created acount.

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed

  Scenario: Create account to modify
    Given I can go to "ACCOUNT" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | ACCOUNT_NAME | Account to Modify |
    Then I can go to "ACCOUNT" Section
    And I can verify if "Account to Modify" was created/modified on Detail Page

  Scenario: Edit account with all fields filled
    When I can go to "ACCOUNT" Section
    And I can click on "Account to Modify" at list on Main Page
    And I can click on Edit Button
    And I can fill the fields of Account and press the save button
      | ACCOUNT_NAME   | Account Modified    |
      | ACCOUNT_NUMBER | 100                 |
      | ACCOUNT_SITE   | 2                   |
      | PARENT_ACCOUNT | Edge Communications |
      | TYPE           | Prospect            |
      | INDUSTRY       | Agriculture         |
      | ANNUAL_REVENUE | 200                 |
      | RATING         | Hot                 |
      | PHONE          | 591591591           |
      | FAX            | 591591222           |
      | WEBSITE        | www.website.com     |
      | TICKER_SYMBOL  | ACC                 |
      | OWNERSHIP      | Private             |
      | EMPLOYEES      | 10                  |
      | SIC_CODE       | 200200200           |
    Then I can go to "ACCOUNT" Section
    And I can verify if "Account Modified" was created/modified on Detail Page

  Scenario: Delete account
    Given I can go to "ACCOUNT" Section
    When I can click on "Account Modified" at list on Main Page
    And I can click on Delete Button
    And I can confirm Delete alert
    Then I can verify that "Account Modified" was deleted

