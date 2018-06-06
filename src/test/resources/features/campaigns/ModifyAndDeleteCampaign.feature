Feature: Modify/delete a campaign

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed
    And I go to "CAMPAIGN" Section
    And I click on New button
    And I create or modify a campaign fill the fields and press the save button
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
    And I go to "CAMPAIGN" Section
    Then I verify if "Campaign3" "CAMPAIGN" was created/modified on Detail Page

  @deleteCampaign
  Scenario: Edit campaign with all fields filled
    When I go to "CAMPAIGN" Section
    And I click on "Campaign3" "CAMPAIGN" at list on Main Page
    And I click on Edit Button
    And I create or modify a campaign fill the fields and press the save button
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
    And I go to "CAMPAIGN" Section
    Then I verify if "Campaign4" "CAMPAIGN" was created/modified on Detail Page

  @deleteCampaign
  Scenario: Edit campaign at list on Main page
    When I go to "CAMPAIGN" Section
    And I edit "Campaign3" at list on Main Page
    And I create or modify a campaign fill the fields and press the save button
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
    And I go to "CAMPAIGN" Section
    Then I verify if "Campaign4" "CAMPAIGN" was created/modified on Detail Page

  Scenario: Delete account
    Given I go to "CAMPAIGN" Section
    When I click on "Campaign3" "CAMPAIGN" at list on Main Page
    And I click on Delete Button
    Then I verify that "Campaign4" "CAMPAIGN" was deleted

  Scenario: Delete account
    Given I go to "CAMPAIGN" Section
    And I delete "Campaign3" at list on Main Page
    Then I verify that "Campaign4" "CAMPAIGN" was deleted