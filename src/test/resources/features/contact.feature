Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given Go to contacts section
    When I press new contacts button a new form is displayed
    And I fill the required information and I press Save
    Then The system shows the new contact

  Scenario: Modify an existing contact
    Given Go to contacts section
    When I choose a contact from recent contacts and I click on edit contact
    And I edit the contact name field and I press the save button
    Then The system shows the modified contact

  Scenario: Delete an existing contact
    Given Go to contacts section
    When I choose a contact from recent contacts and I click on delete contact
    And I click on ok button
    Then The system deletes the selected contact


