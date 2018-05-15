Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then I login to the application
    And I create a new contact
      | contactLastName   | mora           |

  Scenario: Modify an existing contact
    Given Go to contacts section
    And I choose a contact from recent contacts and I click on edit contact
    And I edit the contact name field and I press the save button
      | contactName       | Mora            |
      | contactLastName   | killman         |
      | contactTitle      | ing             |
      | contactDepartment | Systems         |
      | contactBirthday   | 16/05/2018      |
      | contactLeadSource | Web             |
      | contactPhone      | 78787878        |
      | contactHomePhone  | 969969675       |
    Then The system shows the modified contact
      | contactName       | Mora            |
      | contactLastName   | killman         |

  Scenario: Delete an existing contact
    Given Go to contacts section
    When I choose a contact from recent contacts and I click on delete contact
    And I click on ok button
    Then The system deletes the selected contact
