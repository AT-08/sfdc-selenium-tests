Feature: Create a new account

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed

  Scenario: Create a new opportunity with only obligatory fields filled
    Given I can go to "OPPORTUNITY" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | OPPORTUNITY_NAME       | Mora        |
      | OPPORTUNITY_CLOSE_DATE | 17/05/2018  |
      | OPPORTUNITY_STAGE      | Prospecting |
    Then I can verify if "Mora" has been created