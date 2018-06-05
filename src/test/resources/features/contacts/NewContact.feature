Feature: Contacts feature

  Background: User is logged in the application
    Given I login as a User
    Then Home Page should be displayed

  @deleteContact
  Scenario: Create a new contact with only obligatory fields filled
    Given I go to "CONTACT" Section
    And I click on New button
    And I fill the fields of Contact and press the save button
      | CONTACT_LAST_NAME | capibara |
    Then I go to "CONTACT" Section
    And I verify if "capibara" "CONTACT" was created/modified on Detail Page

  Scenario: Create a new contact with all fields filled
    Given I go to "CONTACT" Section
    And I click on New button
    And I fill the fields of Contact and press the save button
      | CONTACT_SALUTATION      | Dr.             |
      | CONTACT_NAME            | Danae           |
      | CONTACT_LAST_NAME       | Ledezma         |
      | CONTACT_TITLE           | title           |
      | CONTACT_DEPARTMENT      | Salees          |
      | CONTACT_BIRTHDAY        | 5/4/2018        |
      | CONTACT_PHONE           | 78787878        |
      | CONTACT_HOME_PHONE      | 555555555       |
      | CONTACT_MOBILE          | 72727272        |
      | CONTACT_OTHER_PHONE     | 72727270        |
      | CONTACT_FAX             | 2222222         |
      | CONTACT_EMAIL           | danae@gmail.com |
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
    Then I go to "CONTACT" Section
    And I verify if "Ledezma, Danae" "CONTACT" was created/modified on Detail Page
