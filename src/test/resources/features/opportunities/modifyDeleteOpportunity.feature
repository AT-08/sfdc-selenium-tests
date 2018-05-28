Feature: Opportunity features

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed
    And I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | OPPORTUNITY_NAME       | Mora        |
      | OPPORTUNITY_CLOSE_DATE | 17/05/2018  |
      | OPPORTUNITY_STAGE      | Prospecting |

  Scenario: Edit opportunity with all fields filled
    When I can click on last element at list on Main Page
    And I can fill the fields of Account and press the save button
      | OPPORTUNITY_NAME       | Coco        |
      | OPPORTUNITY_CLOSE_DATE | 18/05/2030  |
      | OPPORTUNITY_STAGE      | Prospecting |
    Then I can verify if "Coco" was created/modified on Detail Page

  Scenario: Delete account
    Given I can go to "OPPORTUNITY" Section
    When I choose an account and press the delete button
    Then I can verify that the account was deleted