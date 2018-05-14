Feature: Contacts feature

  Background: User is logged in the application
    Given Open the Firefox and launch the application enter the Username and Password and press login
    Then login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given Go to contacts section
    When I press new contacts button a new form is displayed
    And I fill the required information and I press Save
      | contactLastName   | capibara        |
    Then The system shows the new contact
      | contactLastName   | capibara        |

  Scenario: Create a new contact with with all fields filled
    Given Go to contacts section
    When I press new contacts button a new form is displayed
    And I fill the required information and I press Save
      | contactName       | kiwi            |
      | contactLastName   | capibara        |
      | contactTitle      | ing             |
      | contactDepartment | Sales           |
      | contactBirthday   | 15/05/2018      |
      | contactLeadSource | Web             |
      | contactPhone      | 78787878        |
      | contactHomePhone  | 969969675       |
    Then The system shows the new contact
      | contactName       | kiwi            |
      | contactLastName   | capibara        |
