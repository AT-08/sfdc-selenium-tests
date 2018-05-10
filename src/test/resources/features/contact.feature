Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application
    When Enter the Username and Password
    Then login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given Go to contacts section
    When I press new contacts button

