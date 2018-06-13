Feature: Modify and delete a previous created acount.

#  Background: User is logged in the application
#    Given I login as a User
#    When Home Page should be displayed
#    And I go to "ACCOUNT" Section
#    And I click on New button
#    And I fill the fields of Account and press the save button
#      | ACCOUNT_NAME | Account to Modify |
#    And I go to "ACCOUNT" Section
#    Then I verify if "Account to Modify" "ACCOUNT" was created/modified on Detail Page

  @deleteAccount
  Scenario: Edit account with all fields filled
    When I go to "ACCOUNT" Section
    And I click on "Account to Modify" "ACCOUNT" at list on Main Page
    And I click on Edit Button
    And I fill the fields of Account and press the save button
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
    And I go to "ACCOUNT" Section
    Then I verify if "Account Modified" "ACCOUNT" was created/modified on Detail Page

  @deleteAccount
  Scenario: Edit account at list on Main Page
    When I go to "ACCOUNT" Section
    And I edit "Account to Modify" at list on Main Page
    And I fill the fields of Account and press the save button
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
    And I go to "ACCOUNT" Section
    Then I verify if "Account Modified" "ACCOUNT" was created/modified on Detail Page

  Scenario: Delete account
    Given I go to "ACCOUNT" Section
    When I click on "Account to Modify" "ACCOUNT" at list on Main Page
    And I click on Delete Button
    Then I verify that "Account to Modify" "ACCOUNT" was deleted

  Scenario: Delete account at list on Main Page
    When I go to "ACCOUNT" Section
    And  I delete "Account to Modify" at list on Main Page
    Then I verify that "Account to Modify" "ACCOUNT" was deleted

  Scenario: Delete an Account trough API
    When I delete an Account with "/Account/[Account.id]" endpoint
