Feature: Contacts feature

  Background: User is logged in the application
    Given I login as a User
    When Home Page should be displayed
    And I go to "CONTACT" Section
    And I click on New button
    And I fill the fields of Contact and press the save button
      | CONTACT_NAME      | Pablo     |
      | CONTACT_LAST_NAME | Grillosss |
    And I go to "CONTACT" Section
    Then I verify if "Grillosss, Pablo" "CONTACT" was created/modified on Detail Page
  @deleteContact
  Scenario: Edit contact with all fields filled
    When I go to "CONTACT" Section
    And I click on "Grillosss, Pablo" "CONTACT" at list on Main Page
    And I click on Edit Button
    And I fill the fields of Contact and press the save button
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
    And I go to "CONTACT" Section
    Then I verify if "Grillo, Pepe Pablo" "CONTACT" was created/modified on Detail Page
  @deleteContact
  Scenario: Edit contact at list on Main Page
    When I go to "CONTACT" Section
    And   I edit "Grillosss, Pablo" at list on Main Page
    And I fill the fields of Contact and press the save button
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
    And I go to "CONTACT" Section
    Then I verify if "Grillo, Pepe Pablo" "CONTACT" was created/modified on Detail Page

  Scenario: Delete contact
    Given I go to "CONTACT" Section
    When I click on "Grillosss, Pablo" "CONTACT" at list on Main Page
    And I click on Delete Button
    Then I verify that "Grillosss, Pablo" "CONTACT" was deleted

  Scenario: Delete contact at list on Main Page
    When I go to "CONTACT" Section
    And  I delete "Grillosss, Pablo" at list on Main Page
    Then I verify that "Grillosss, Pablo" "CONTACT" was deleted