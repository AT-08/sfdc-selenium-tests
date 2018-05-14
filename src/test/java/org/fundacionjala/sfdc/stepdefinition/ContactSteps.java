package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Contacts.SFCDetailsPage;
import org.fundacionjala.sfdc.pageobjects.Contacts.SFCMainPage;
import org.fundacionjala.sfdc.pageobjects.Contacts.SFCNewModifyPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceContacts;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;
import java.util.Properties;
import java.util.StringJoiner;

/**
 * ContactSteps.java
 * Class for steps of account.feature.
 */
public class ContactSteps {
    private WebDriver webDriver;
    private SalesForceContacts salesForceContacts;
    private Properties propertiesManager;
    private SFCDetailsPage contactsDetailPage;
    private SFCMainPage contactsMainPage;
    private SFCNewModifyPage contactsNewModifyPage;


    /**
     * Given step.
     */
    @Given("^Go to contacts section$")
    public void goToContactsSection() {
        System.out.println("This Step goes to contacts section");
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic("a.contactBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();

    }

    /**
     * When step.
     */
    @When("^I press new contacts button a new form is displayed$")
    public void IPressNewContactsButtonANewFormIsDisplayed() {
        System.out.println("This Step presses new account button");
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickNewButton();
    }


    /**
     * And step.
     */
    @And("^I fill the required information and I press Save$")
    public void IFillTheRequiredInformationAndIPressSave(Map<String, String> values) {
        System.out.println("This Step fills account name field");
        contactsNewModifyPage = new SFCNewModifyPage();
        CommonActions.setValues(values, contactsNewModifyPage.fillMethodsToFields());
        CommonActions.clickElement(contactsNewModifyPage.getSaveContactButton());
    }
    /**
     * Then step.
     */
    @Then("^The system shows the new contact$")
    public void TheSystemShowsTheNewContact(Map<String, String> values) {
        contactsDetailPage = new SFCDetailsPage();
        System.out.println("This Step tests new account creation:" + contactsDetailPage.newContactSavedName());
        Assert.assertEquals(contactsDetailPage.newContactSavedName(), values.get("contactLastName"));
    }
    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on edit contact")
    public void IChooseAContactFromRecentContactsAndIClickOnEditContact() {
        System.out.println("Choose last contact");
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickContactNameLink();
        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickEditContact();

    }
    /**
     * And step.
     */
    @And("^I edit the contact name field and I press the save button")
    public void IEditTheContactNameFieldAndIPressTheSaveButton(Map<String, String> values) {
        System.out.println("This Step edits contact name field");
        contactsNewModifyPage = new SFCNewModifyPage();
        CommonActions.setValues(values, contactsNewModifyPage.fillMethodsToFields());
        contactsNewModifyPage.clickSaveContactButton();
    }

    /**
     * Then step.
     */
    @Then("^The system shows the modified contact$")
    public void TheSystemShowsTheModifiedContact(Map<String, String> values) {
        contactsDetailPage = new SFCDetailsPage();
        StringJoiner name = new StringJoiner(" ");
        name.add(values.get("contactName")).add(values.get("contactLastName"));
        Assert.assertEquals(contactsDetailPage.newContactSavedName(), name.toString());
    }
    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on delete contact")
    public void IChooseAContactFromRecentContactsAndIClickOnDeleteContact() {
        System.out.println("Choose last contact");
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickContactNameLink();
        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickDeleteContact();
    }
    /**
     * And step.
     */
    @And("^I click on ok button")
    public void IClickOnOkButton() {
        System.out.println("Delete contact");

        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickDeleteAlert();

    }
    /**
     * Then step.
     */
    @Then("^The system deletes the selected contact$")
    public void TheSystemDeletesTheSelectedContact() {

        propertiesManager = PropertiesManager.getInstance().getConfig();
        contactsMainPage = new SFCMainPage();
        System.out.println("This Step tests verified id the contact:");
        Assert.assertEquals(contactsMainPage.contactHomePage(), "Home");
    }

    /**
     * And step.
     */
    @And("^I create a new contact$")
    public void ICreateANewContact(Map<String, String> values) {
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic("a.contactBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();

        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickNewButton();

        contactsNewModifyPage = new SFCNewModifyPage();
        CommonActions.setValues(values, contactsNewModifyPage.fillMethodsToFields());
        CommonActions.clickElement(contactsNewModifyPage.getSaveContactButton());
    }

    /**
     * After, to close browser after the tests are executed.
     */
    /*@After
    public void closeBrowser() {
        System.out.println("This Step closes browser");
        webDriver = DriverManager.getInstance().getNavigator();
        webDriver.close();
    }*/


}