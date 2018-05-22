Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    When I login to the application
    And I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME       | kiwi       |
      | CONTACT_LASTNAME   | capibara   |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 15/05/2018 |
      | CONTACT_LEADSOURCE | Web        |

  Scenario: Edit account with all fields filled
    Given I can go to contact section
    When I choose an contact and press the edit button
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME       | Mani       |
      | CONTACT_LASTNAME   | Chocolate  |
      | CONTACT_TITLE      | Doctor     |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 21/12/2020 |
      | CONTACT_LEADSOURCE | Other      |
    Then I can verify the new contact "Mani Chocolate"

  Scenario: Delete contact
    Given I can go to contact section
    When I choose an contact and press the delete button
    Then I can verify that the contact was deleted