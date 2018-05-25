Feature: Create a new account

  Background: User is logged in the application
    Given Open Browser and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new opportunity with only obligatory fields filled
    Given I can go to opportunity section
    And I can create a new opportunity
    And I can create a new opportunity fill the fields and press the save button
      | OPPORTUNITY_NAME       | Mora        |
      | OPPORTUNITY_CLOSE_DATE | 17/05/2018  |
      | OPPORTUNITY_STAGE      | Prospecting |
    Then I can verify the new opportunity "Mora"