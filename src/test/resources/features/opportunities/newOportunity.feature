Feature: Create a new account

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed

  Scenario: Create a new opportunity with only mandatory fields filled
    Given I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can create or modify an opportunity fill the fields and press the save button
      | OPPORTUNITY_NAME       | Mora        |
      | OPPORTUNITY_CLOSE_DATE | 17/05/2018  |
      | OPPORTUNITY_STAGE      | Prospecting |
    Then I can go to "OPPORTUNITY" Section
    And I can verify if "Mora" was created/modified on Detail Page

  Scenario: Create a new opportunity with all fields filled
    Given I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can create or modify an opportunity fill the fields and press the save button
      | OPPORTUNITY_PRIVATE                     | true          |
      | OPPORTUNITY_NAME                        | Mora2         |
      | OPPORTUNITY_ACCOUNT_NAME                | newaccount    |
      | OPPORTUNITY_TYPE                        | New Customer  |
      | OPPORTUNITY_LEAD_SOURCE                 | Web           |
      | OPPORTUNITY_AMOUNT                      | 500           |
      | OPPORTUNITY_CLOSE_DATE                  | 17/06/2018    |
      | OPPORTUNITY_NEXT_STEP                   | 17/05/2018    |
      | OPPORTUNITY_STAGE                       | Prospecting   |
      | OPPORTUNITY_PROBABILITY                 | 70            |
      | OPPORTUNITY_ORDER_NUMBER                | 12345         |
      | OPPORTUNITY_CURRENT_GENERATOR           | Current       |
      | OPPORTUNITY_TRACKING                    | 123123        |
      | OPPORTUNITY_MAIN_COMPETITORS            | Competitor1   |
      | OPPORTUNITY_DELIVERY_INSTALLATION_STATUS| Completed     |
      | OPPORTUNITY_DESCRIPTION                 | Description   |
    Then I can go to "OPPORTUNITY" Section
    And I can verify if "Mora2" was created/modified on Detail Page