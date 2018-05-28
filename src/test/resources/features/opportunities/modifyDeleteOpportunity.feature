Feature: Modify and delete a previous created opportunity.

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed

  Scenario: Create opportunity to modify
    Given I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can create or modify an opportunity fill the fields and press the save button
      | OPPORTUNITY_PRIVATE                     | true          |
      | OPPORTUNITY_NAME                        | Opportunity   |
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
    And I can verify if "Opportunity" was created/modified on Detail Page

  Scenario: Edit account with all fields filled
    When I can go to "OPPORTUNITY" Section
    And I can click on "Opportunity" at list on Main Page
    And I can click on Edit Button
    And I can create or modify an opportunity fill the fields and press the save button
      | OPPORTUNITY_PRIVATE                     | false         |
      | OPPORTUNITY_NAME                        | OpportunityMod|
      | OPPORTUNITY_ACCOUNT_NAME                | newaccount2   |
      | OPPORTUNITY_TYPE                        | New Customer  |
      | OPPORTUNITY_LEAD_SOURCE                 | Other         |
      | OPPORTUNITY_AMOUNT                      | 5000          |
      | OPPORTUNITY_CLOSE_DATE                  | 17/06/2018    |
      | OPPORTUNITY_NEXT_STEP                   | 17/08/2018    |
      | OPPORTUNITY_STAGE                       | Qualification |
      | OPPORTUNITY_PROBABILITY                 | 50            |
      | OPPORTUNITY_ORDER_NUMBER                | 2020          |
      | OPPORTUNITY_CURRENT_GENERATOR           | Current2      |
      | OPPORTUNITY_TRACKING                    | 213213        |
      | OPPORTUNITY_MAIN_COMPETITORS            | Competitor2   |
      | OPPORTUNITY_DELIVERY_INSTALLATION_STATUS| In progress   |
      | OPPORTUNITY_DESCRIPTION                 | Don't modify  |
    Then I can go to "OPPORTUNITY" Section
    And I can verify if "OpportunityMod" was created/modified on Detail Page

  Scenario: Delete account
    Given I can go to "OPPORTUNITY" Section
    When I can click on "OpportunityMod" at list on Main Page
    And I can click on Delete Button
    And I can confirm Delete alert
    Then I can verify that "OpportunityMod" was deleted
