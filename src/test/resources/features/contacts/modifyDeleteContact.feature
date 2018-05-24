Feature: Contacts feature

  Background: User is logged in the application
    Given Open Browser and launch the application enter the Username and Password and press login
    When I login to the application
    And I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME            | Pep            |
      | CONTACT_LAST_NAME       | Grillo         |
      | CONTACT_TITLE           | title          |
      | CONTACT_DEPARTMENT      | Sales          |
      | CONTACT_BIRTHDAY        | 5/4/2018       |
      | CONTACT_PHONE           | 78787878       |
      | CONTACT_HOME_PHONE      | 969969675      |
      | CONTACT_MOBILE          | 72727272       |
      | CONTACT_OTHER_PHONE     | 72727270       |
      | CONTACT_FAX             | 11111111       |
      | CONTACT_EMAIL           | pepe@gmail.com |
      | CONTACT_ASSISTANT       | assistant      |
      | CONTACT_ASST_PHONE      | 22222222       |
      | CONTACT_MAILING_STREET  | prado          |
      | CONTACT_OTHER_STREET    | prado2         |
      | CONTACT_MAILING_CITY    | Cochabamba     |
      | CONTACT_OTHER_CITY      | Tarija         |
      | CONTACT_MAILING_STATE   | America        |
      | CONTACT_OTHER_STATE     | Pando          |
      | CONTACT_MAILING_ZIP     | 591            |
      | CONTACT_OTHER_ZIP       | 0000           |
      | CONTACT_MAILING_COUNTRY | Bolivia        |
      | CONTACT_OTHER_COUNTRY   | Argentina      |
      | CONTACT_LANGUAGES       | ingles         |
      | CONTACT_DESCRIPTION     | This is a test |

  Scenario: Edit account with all fields filled
    Given I can go to contact section
    When I choose an contact and press the edit button
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME            | Papa            |
      | CONTACT_LAST_NAME       | Grillos         |
      | CONTACT_TITLE           | title1          |
      | CONTACT_BIRTHDAY        | 6/4/2018        |
      | CONTACT_PHONE           | 78787838        |
      | CONTACT_HOME_PHONE      | 969969475       |
      | CONTACT_MOBILE          | 72727272        |
      | CONTACT_OTHER_PHONE     | 72527270        |
      | CONTACT_FAX             | 11311111        |
      | CONTACT_EMAIL           | pepes@gmail.com |
      | CONTACT_ASSISTANT       | assistants      |
      | CONTACT_ASST_PHONE      | 22221222        |
      | CONTACT_MAILING_STREET  | prado           |
      | CONTACT_OTHER_STREET    | prado2          |
      | CONTACT_MAILING_CITY    | Cocha           |
      | CONTACT_OTHER_CITY      | Tarijas         |
      | CONTACT_MAILING_STATE   | Americas        |
      | CONTACT_OTHER_STATE     | Pandos          |
      | CONTACT_MAILING_ZIP     | 5911            |
      | CONTACT_OTHER_ZIP       | 0000            |
      | CONTACT_MAILING_COUNTRY | Bolivia         |
      | CONTACT_OTHER_COUNTRY   | Chile           |
      | CONTACT_LANGUAGES       | spanish         |
      | CONTACT_DESCRIPTION     | This is a test2 |
    Then I can verify the new contact "Papa Grillos"

  Scenario: Delete contact
    Given I can go to contact section
    When I choose an contact and press the delete button
    Then I can verify that the contact was deleted