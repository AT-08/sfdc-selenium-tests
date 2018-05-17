Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_LASTNAME | capibara |
    Then I can verify the new contact "capibara"

  Scenario: Create a new contact with all fields filled
    Given I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME       | kiwi       |
      | CONTACT_LASTNAME   | capibara   |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 15/05/2018 |
      | CONTACT_LEADSOURCE | Web        |
      | CONTACT_PHONE      | 78787878   |
      | CONTACT_HOMEPHONE  | 969969675  |
    Then I can verify the new contact "kiwi capibara"