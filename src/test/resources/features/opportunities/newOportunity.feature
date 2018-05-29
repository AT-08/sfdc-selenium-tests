Feature: Create a new account

  Background: User is logged, create an account and a new campaign
    Given I login as a User
    And Home Page should be displayed
    And I can go to "ACCOUNT" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | ACCOUNT_NAME    | AccountOpp   |
    And I can go to "CAMPAIGN" Section
    And I can click on New button
    And I can create or modify a campaign fill the fields and press the save button
      | CAMPAIGN_NAME   | CampaignOpp  |
      | CAMPAIGN_ACTIVE | true         |

  @deleteAccount @deleteCampaign
  Scenario: Create a new opportunity with all fields filled
    Given I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can create or modify an opportunity fill the fields and press the save button
      | OPPORTUNITY_PRIVATE                     | true          |
      | OPPORTUNITY_NAME                        | Mora2         |
      | OPPORTUNITY_ACCOUNT_NAME                | AccountOpp    |
      | OPPORTUNITY_TYPE                        | New Customer  |
      | OPPORTUNITY_LEAD_SOURCE                 | Web           |
      | OPPORTUNITY_AMOUNT                      | 500           |
      | OPPORTUNITY_CLOSE_DATE                  | 17/06/2018    |
      | OPPORTUNITY_NEXT_STEP                   | 17/05/2018    |
      | OPPORTUNITY_STAGE                       | Prospecting   |
      | OPPORTUNITY_PROBABILITY                 | 70            |
      | OPPORTUNITY_PRIMARY_CAMPAIGN_SOURCE     | CampaignOpp   |
      | OPPORTUNITY_ORDER_NUMBER                | 12345         |
      | OPPORTUNITY_CURRENT_GENERATOR           | Current       |
      | OPPORTUNITY_TRACKING                    | 123123        |
      | OPPORTUNITY_MAIN_COMPETITORS            | Competitor1   |
      | OPPORTUNITY_DELIVERY_INSTALLATION_STATUS| Completed     |
      | OPPORTUNITY_DESCRIPTION                 | Description   |
    And I can go to "OPPORTUNITY" Section
    Then I can verify if "Mora2" was created/modified on Detail Page