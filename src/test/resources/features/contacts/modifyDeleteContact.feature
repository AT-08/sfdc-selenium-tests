Feature: Contacts feature

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed
    And I can go to "CONTACTS" Section
    And I can click on New button
    And I can fill the fields of Account and press the save button
      | CONTACT_NAME       | kiwi       |
      | CONTACT_LASTNAME   | capibara   |
      | CONTACT_TITLE      | ing        |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 15/05/2018 |
      | CONTACT_LEADSOURCE | Web        |

  Scenario: Edit account with all fields filled
    When I click on edit button to new account created
    And I can fill the fields of Account and press the save button
      | CONTACT_NAME       | Mani       |
      | CONTACT_LASTNAME   | Chocolate  |
      | CONTACT_TITLE      | Doctor     |
      | CONTACT_DEPARTMENT | Sales      |
      | CONTACT_BIRTHDAY   | 21/12/2020 |
      | CONTACT_LEADSOURCE | Other      |
    Then I can verify the new contact "Mani Chocolate"

  Scenario: Delete account
    Given I can go to "CONTACTS" Section
    When I choose an account and press the delete button
    Then I can verify that the account was deleted