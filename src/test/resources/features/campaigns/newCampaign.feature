Feature: Create a new campaign

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed

  Scenario: Create a new campaign with only mandatory fields filled
    Given I can go to "CAMPAIGN" Section
    And I can click on New button
    And I can create or modify a campaign fill the fields and press the save button
      | CAMPAIGN_NAME   | CampaignTest |
      | CAMPAIGN_ACTIVE | true         |
    Then I can go to "CAMPAIGN" Section
    And I can verify if "CampaignTest" was created/modified on Detail Page

  Scenario: Create a new campaign with all fields filled
    Given I can go to "CAMPAIGN" Section
    And I can click on New button
    And I can create or modify a campaign fill the fields and press the save button
      | CAMPAIGN_NAME             | Campaign   |
      | CAMPAIGN_ACTIVE           | true       |
      | CAMPAIGN_TYPE             | Webinar    |
      | CAMPAIGN_STATUS           | Aborted    |
      | CAMPAIGN_START_DATE       | 28/05/2018 |
      | CAMPAIGN_END_DATE         | 30/06/2018 |
      | CAMPAIGN_EXPECTED_REVENUE | 100        |
      | CAMPAIGN_BUDGETED_COST    | 200        |
      | CAMPAIGN_ACTUAL_COST      | 50         |
      | CAMPAIGN_EXPECTED_RESPONSE| 23,57      |
      | CAMPAIGN_NUM_SENT         | 25         |
      | CAMPAIGN_PARENT           | Camp123    |
      | CAMPAIGN_DESCRIPTION      | Desc123    |
    Then I can go to "CAMPAIGN" Section
    And I can verify if "Campaign" was created/modified on Detail Page

