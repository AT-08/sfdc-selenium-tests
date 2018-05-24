Feature: Contacts feature

  Background: User is logged in the application
    Given Open Browser and launch the application enter the Username and Password and press login
    Then I login to the application

  Scenario: Create a new contact with only obligatory fields filled
    Given I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_LASTNAME | capibara |
    Then I can verify the new contact "capibara"

  Scenario: Create a new contact with all fields filled
    Given I can go to contact section
    And I can create a new contact
    And I can create a new contact fill the fields and press the save button
      | CONTACT_NAME            | Pepe           |
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
    Then I can verify the new contact "Pepe Grillo"