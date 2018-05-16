Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application
    And I create a new contact
      | CONTACT_LASTNAME | mora |

  Scenario: Modify an existing contact
    Given Go to contacts section
    And I choose a contact from recent contacts and I click on edit contact
    And I edit the contact name field and I press the save button
      | CONTACT_NAME       | Mora       |
      | CONTACT_LASTNAME   | killman    |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Systems    |
      | CONTACT_BIRTHDAY   | 16/05/2018 |
      | CONTACT_LEADSOURCE | Web        |
      | CONTACT_PHONE      | 78787878   |
      | CONTACT_HOMEPHONE  | 969969675  |
    Then The system shows the modified contact "Mora killman"

  Scenario: Delete an existing contact
    Given Go to contacts section
    When I choose a contact from recent contacts and I click on delete contact
    And I click on ok button
    Then The system deletes the selected contact
