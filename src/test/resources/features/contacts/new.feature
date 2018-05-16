Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given Go to contacts section
    When I press new contacts button a new form is displayed
    And I fill the required information and I press Save
      | CONTACT_LASTNAME | capibara |
    Then The system shows the new contact "capibara"

  Scenario: Create a new contact with with all fields filled
    Given Go to contacts section
    When I press new contacts button a new form is displayed
    And I fill the required information and I press Save
      | CONTACT_NAME       | kiwi       |
      | CONTACT_LASTNAME   | capibara   |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 15/05/2018 |
      | CONTACT_LEADSOURCE | Web        |
      | CONTACT_PHONE      | 78787878   |
      | CONTACT_HOMEPHONE  | 969969675  |
    Then The system shows the new contact "kiwi capibara"