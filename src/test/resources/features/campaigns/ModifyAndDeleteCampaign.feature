Feature: Modify/delete a campaign

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed
    And I can go to "CAMPAIGN" Section
    And I can click on New button
    And I can create or modify a campaign fill the fields and press the save button
      | CAMPAIGN_NAME              | Campaign3  |
      | CAMPAIGN_ACTIVE            | true       |
      | CAMPAIGN_TYPE              | Webinar    |
      | CAMPAIGN_STATUS            | Aborted    |
      | CAMPAIGN_START_DATE        | 28/05/2018 |
      | CAMPAIGN_END_DATE          | 30/07/2018 |
      | CAMPAIGN_EXPECTED_REVENUE  | 100        |
      | CAMPAIGN_BUDGETED_COST     | 200        |
      | CAMPAIGN_ACTUAL_COST       | 50         |
      | CAMPAIGN_EXPECTED_RESPONSE | 55,57      |
      | CAMPAIGN_NUM_SENT          | 25         |
      | CAMPAIGN_PARENT            | Camp123    |
      | CAMPAIGN_DESCRIPTION       | Desc456    |
    And I can go to "CAMPAIGN" Section
    Then I can verify if "Campaign3" "CAMPAIGN" was created/modified on Detail Page

  Scenario: Edit account with all fields filled
    When I can go to "CAMPAIGN" Section
    And I can click on "Campaign3" "CAMPAIGN" at list on Main Page
    And I can click on Edit Button
    And I can create or modify a campaign fill the fields and press the save button
      | CAMPAIGN_NAME              | Campaign4   |
      | CAMPAIGN_ACTIVE            | true        |
      | CAMPAIGN_TYPE              | Webinar     |
      | CAMPAIGN_STATUS            | In Progress |
      | CAMPAIGN_START_DATE        | 28/05/2018  |
      | CAMPAIGN_END_DATE          | 30/06/2018  |
      | CAMPAIGN_EXPECTED_REVENUE  | 50          |
      | CAMPAIGN_BUDGETED_COST     | 100         |
      | CAMPAIGN_ACTUAL_COST       | 75          |
      | CAMPAIGN_EXPECTED_RESPONSE | 34,78       |
      | CAMPAIGN_NUM_SENT          | 67          |
      | CAMPAIGN_PARENT            | Camp123     |
      | CAMPAIGN_DESCRIPTION       | Desc7809    |
    And I can go to "CAMPAIGN" Section
    Then I can verify if "Campaign4" "CAMPAIGN" was created/modified on Detail Page

  Scenario: Delete account
    Given I can go to "CAMPAIGN" Section
    When I can click on "Campaign4" "CAMPAIGN" at list on Main Page
    And I can click on Delete Button
    Then I can verify that "Campaign4" "CAMPAIGN" was deleted