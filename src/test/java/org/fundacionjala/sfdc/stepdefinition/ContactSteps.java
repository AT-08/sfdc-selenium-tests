package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceContacts;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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


    /**
     * Given step.
     */
    @Given("^Go to contacts section$")
    public void goToContactsSection() {
        System.out.println("This Step goes to contacts section");
        webDriver = DriverManager.getInstance().getNavigator();
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "a.contactBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();

        salesForceMainTab.goToAccounts();

    }

    /**
     * When step.
     */
    @When("^I press new contacts button a new form is displayed$")
    public void IPressNewContactsButtonANewFormIsDisplayed() {
        System.out.println("This Step presses new account button");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.clickNewButton(salesForceContacts.getNewButton());
    }


    /**
     * And step.
     */
    @And("^I fill the required information and I press Save$")
    public void IFillTheRequiredInformationAndIPressSave() {
        System.out.println("This Step fills account name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.fillInfoNewContact(propertiesManager.getProperty("contactName"), propertiesManager.getProperty("contactLastName"));
        salesForceContacts.clickSaveContactButton(salesForceContacts.getSaveContactButton());
    }
    /**
     * Then step.
     */
    @Then("^The system shows the new contact$")
    public void TheSystemShowsTheNewContact() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceContacts = new SalesForceContacts(webDriver);
        System.out.println("This Step tests new account creation:" + salesForceContacts.newContactSavedName());
        StringJoiner name = new StringJoiner(" ");
        name.add(propertiesManager.getProperty("contactName"));
        name.add(propertiesManager.getProperty("contactLastName"));
        Assert.assertEquals(salesForceContacts.newContactSavedName(), name.toString());
    }
    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on edit contact")
    public void IChooseAContactFromRecentContactsAndIClickOnEditContact() {
        System.out.println("Choose last contact");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.clickContactNameLink();
        salesForceContacts.clickEditContact();

    }
    /**
     * And step.
     */
    @And("^I edit the contact name field and I press the save button")
    public void IEditTheContactNameFieldAndIPressTheSaveButton() {
        System.out.println("This Step edits contact name field");
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.editContact(propertiesManager.getProperty("contactEditName"));
        salesForceContacts.clickSaveContactButton(salesForceContacts.getSaveContactButton());

    }

    /**
     * Then step.
     */
    @Then("^The system shows the modified contact$")
    public void TheSystemShowsTheModifiedContact() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceContacts = new SalesForceContacts(webDriver);
        System.out.println("This Step tests modified contact:" + salesForceContacts.newContactSavedName());
        StringJoiner name = new StringJoiner(" ");
        name.add(propertiesManager.getProperty("contactEditName"));
        name.add(propertiesManager.getProperty("contactLastName"));
        Assert.assertEquals(salesForceContacts.newContactSavedName(), name.toString());
    }
    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on delete contact")
    public void IChooseAContactFromRecentContactsAndIClickOnDeleteContact() {
        System.out.println("Choose last contact");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.clickContactNameLink();
        salesForceContacts.clickDeleteContact();
    }
    /**
     * And step.
     */
    @And("^I click on ok button")
    public void IClickOnOkButton() {
        System.out.println("Delete contact");
        webDriver = DriverManager.getInstance().getNavigator();
        salesForceContacts = new SalesForceContacts(webDriver);
        salesForceContacts.clickDeleteAlert();

    }
    /**
     * Then step.
     */
    @Then("^The system deletes the selected contact$")
    public void TheSystemDeletesTheSelectedContact() {
        webDriver = DriverManager.getInstance().getNavigator();
        propertiesManager = PropertiesManager.getInstance().getConfig();
        salesForceContacts = new SalesForceContacts(webDriver);
        System.out.println("This Step tests verified id the contact:");
        Assert.assertEquals(salesForceContacts.contactHomePage(), "Home");
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

