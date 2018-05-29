Feature: Contacts feature

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed
    And I can go to "CONTACT" Section
    And I can click on New button
    And I can fill the fields of Contact and press the save button
      | CONTACT_NAME      | Pablo     |
      | CONTACT_LAST_NAME | Grillosss |
    Then I can go to "CONTACT" Section
    And I can verify if "Grillosss, Pablo" "CONTACT" was created/modified on Detail Page

  Scenario: Edit contact with all fields filled
    When I can go to "CONTACT" Section
    And I can click on "Grillosss, Pablo" "CONTACT" at list on Main Page
    And I can click on Edit Button
    And I can fill the fields of Contact and press the save button
      | CONTACT_SALUTATION      | Dr.             |
      | CONTACT_NAME            | Pepe Pablo      |
      | CONTACT_LAST_NAME       | Grillo          |
      | CONTACT_TITLE           | title           |
      | CONTACT_DEPARTMENT      | Salees          |
      | CONTACT_BIRTHDAY        | 5/4/2018        |
      | CONTACT_PHONE           | 78787878        |
      | CONTACT_HOME_PHONE      | 555555555       |
      | CONTACT_MOBILE          | 72727272        |
      | CONTACT_OTHER_PHONE     | 72727270        |
      | CONTACT_FAX             | 2222222         |
      | CONTACT_EMAIL           | pablo@gmail.com |
      | CONTACT_ASSISTANT       | assistant       |
      | CONTACT_ASST_PHONE      | 22222222        |
      | CONTACT_LEAD_SOURCE     | Web             |
      | CONTACT_MAILING_STREET  | prado           |
      | CONTACT_OTHER_STREET    | prado2          |
      | CONTACT_MAILING_CITY    | Cocha           |
      | CONTACT_OTHER_CITY      | Tarija          |
      | CONTACT_MAILING_STATE   | Americ          |
      | CONTACT_OTHER_STATE     | Pando           |
      | CONTACT_MAILING_ZIP     | 591             |
      | CONTACT_OTHER_ZIP       | 0000            |
      | CONTACT_MAILING_COUNTRY | Bolivia         |
      | CONTACT_OTHER_COUNTRY   | Argentina       |
      | CONTACT_LANGUAGES       | english         |
      | CONTACT_LEVEL           | Secondary       |
      | CONTACT_DESCRIPTION     | This is a test2 |
    Then I can go to "CONTACT" Section
    And I can verify if "Grillo, Pepe Pablo" "CONTACT" was created/modified on Detail Page

  Scenario: Edit contact at list on Main Page
    When I can go to "CONTACT" Section
    And   I can click on Edit Button at list on Main Page
    And I can fill the fields of Contact and press the save button
      | CONTACT_SALUTATION      | Dr.             |
      | CONTACT_NAME            | Pepe Pablo      |
      | CONTACT_LAST_NAME       | Grillo          |
      | CONTACT_TITLE           | title           |
      | CONTACT_DEPARTMENT      | Salees          |
      | CONTACT_BIRTHDAY        | 5/4/2018        |
      | CONTACT_PHONE           | 78787878        |
      | CONTACT_HOME_PHONE      | 555555555       |
      | CONTACT_MOBILE          | 72727272        |
      | CONTACT_OTHER_PHONE     | 72727270        |
      | CONTACT_FAX             | 2222222         |
      | CONTACT_EMAIL           | pablo@gmail.com |
      | CONTACT_ASSISTANT       | assistant       |
      | CONTACT_ASST_PHONE      | 22222222        |
      | CONTACT_LEAD_SOURCE     | Web             |
      | CONTACT_MAILING_STREET  | prado           |
      | CONTACT_OTHER_STREET    | prado2          |
      | CONTACT_MAILING_CITY    | Cocha           |
      | CONTACT_OTHER_CITY      | Tarija          |
      | CONTACT_MAILING_STATE   | Americ          |
      | CONTACT_OTHER_STATE     | Pando           |
      | CONTACT_MAILING_ZIP     | 591             |
      | CONTACT_OTHER_ZIP       | 0000            |
      | CONTACT_MAILING_COUNTRY | Bolivia         |
      | CONTACT_OTHER_COUNTRY   | Argentina       |
      | CONTACT_LANGUAGES       | english         |
      | CONTACT_LEVEL           | Secondary       |
      | CONTACT_DESCRIPTION     | This is a test2 |
    Then I can go to "CONTACT" Section
    And I can verify if "Grillo, Pepe Pablo" "CONTACT" was created/modified on Detail Page

  Scenario: Delete contact
    Given I can go to "CONTACT" Section
    When I can click on "Grillosss, Pablo" "CONTACT" at list on Main Page
    And I can click on Delete Button
    And I can confirm Delete alert
    Then I can verify that "Grillosss, Pablo" "CONTACT" was deleted

  Scenario: Delete contact at list on Main Page
    Given I can go to "CONTACT" Section
    When  I can click on Delete Button at list on Main Page
    Then I can verify that "Grillosss, Pablo" "CONTACT" was deleted