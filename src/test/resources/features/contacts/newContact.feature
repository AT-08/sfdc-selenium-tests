Feature: Contacts feature

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed

  Scenario: Create a new contact with only obligatory fields filled
    Given I can go to "CONTACT" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | CONTACT_LASTNAME | capibara |
    Then I can go to "CONTACT" Section
    And I can verify if "capibara" was created/modified on Detail Page

  Scenario: Create a new contact with all fields filled
    Given I can go to "CONTACT" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | CONTACT_NAME       | kiwi       |
      | CONTACT_LASTNAME   | capibara   |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 15/05/2018 |
      | CONTACT_LEADSOURCE | Web        |
      | CONTACT_PHONE      | 78787878   |
      | CONTACT_HOMEPHONE  | 969969675  |
    Then I can go to "CONTACT" Section
    And I can verify if "kiwi capibara" was created/modified on Detail Page