Feature: Register new contact
  Background: I am going to app launcher page
  Scenario: I will create a new contact
    Given I am on the new contact page
    When I fill in First name with Ariel
    And I fill in Last Name with Gonzales
    And I press Save
    Then I should see a contact called Ariel Gonzales
