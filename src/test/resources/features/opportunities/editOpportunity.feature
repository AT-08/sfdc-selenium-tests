Feature: Edit Opportunity feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new opportunity with only obligatory fields filled
    Given Go to opportunities section
    When I fill the required fields in the new opportunity form
    Then a new opportunity is created

  Scenario: Edit the opportunity created by modifying only obligatory fields filled
    Given Go to opportunities section
    And Select the opportunity created
    When I edit the fields filled in the opportunity form
    Then the opportunity is modified