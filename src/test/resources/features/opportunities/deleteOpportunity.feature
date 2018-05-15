Feature: Delete Opportunity feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new opportunity with only mandatory fields filled
    Given Go to opportunities section
    When I fill the required fields in the new opportunity form
    Then a new opportunity is created

  Scenario: Delete the opportunity created
    Given Go to opportunities section
    When I delete the opportunity created
    Then the opportunity is deleted