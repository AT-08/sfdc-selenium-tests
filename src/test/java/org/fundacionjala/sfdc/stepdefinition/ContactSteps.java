package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCDetailsPage;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCMainPage;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCNewModifyPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Inputs;
import org.testng.Assert;

import java.util.Map;

/**
 * ContactSteps.java
 * Class for steps of account.feature.
 */
public class ContactSteps {
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
    public void iPressNewContactsButtonANewFormIsDisplayed() {
        System.out.println("This Step presses new account button");
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickNewButton();
    }


    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I fill the required information and I press Save$")
    public void iFillTheRequiredInformationAndIPressSave(final Map<Inputs, String> values) {
        System.out.println("This Step fills account name field");
        contactsNewModifyPage = new SFCNewModifyPage();
        values.keySet().stream().forEach((step) ->
                contactsNewModifyPage.getStrategyStepMap(values).get(step).fillField());
        CommonActions.clickElement(contactsNewModifyPage.getSaveContactButton());
    }

    /**
     * And step.
     *
     * @param contactName contact Name.
     */
    @Then("^The system shows the new contact \"([^\"]*)\"$")
    public void theSystemShowsTheNewContact(final String contactName) {
        contactsDetailPage = new SFCDetailsPage();
        Assert.assertEquals(contactsDetailPage.newContactSavedName(), contactName);
    }

    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on edit contact")
    public void iChooseAContactFromRecentContactsAndIClickOnEditContact() {
        System.out.println("Choose last contact");
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickContactNameLink();
        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickEditContact();

    }

    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I edit the contact name field and I press the save button")
    public void iEditTheContactNameFieldAndIPressTheSaveButton(final Map<Inputs, String> values) {
        System.out.println("This Step edits contact name field");
        contactsNewModifyPage = new SFCNewModifyPage();
        values.keySet().stream().forEach(step ->
                contactsNewModifyPage.getStrategyStepMap(values).get(step).fillField());
        contactsNewModifyPage.clickSaveContactButton();
    }

    /**
     * And step.
     *
     * @param accountName accountName.
     */
    @Then("^The system shows the modified contact \"([^\"]*)\"$")
    public void theSystemShowsTheModifiedContact(final String accountName) {
        contactsDetailPage = new SFCDetailsPage();
        Assert.assertEquals(contactsDetailPage.newContactSavedName(), accountName);
    }

    /**
     * When step.
     */
    @When("^I choose a contact from recent contacts and I click on delete contact")
    public void iChooseAContactFromRecentContactsAndIClickOnDeleteContact() {
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickContactNameLink();
        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickDeleteContact();
    }

    /**
     * And step.
     */
    @And("^I click on ok button")
    public void iClickOnOkButton() {
        System.out.println("Delete contact");

        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickDeleteAlert();

    }

    /**
     * Then step.
     */
    @Then("^The system deletes the selected contact$")
    public void theSystemDeletesTheSelectedContact() {
        contactsMainPage = new SFCMainPage();
        Assert.assertEquals(contactsMainPage.contactHomePage(), "Home");
    }

    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I create a new contact$")
    public void iCreateANewContact(final Map<Inputs, String> values) {
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic("a.contactBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
        contactsMainPage = new SFCMainPage();
        contactsMainPage.clickNewButton();
        contactsNewModifyPage = new SFCNewModifyPage();
        values.keySet().stream().forEach((step) ->
                contactsNewModifyPage.getStrategyStepMap(values).get(step).fillField());
        CommonActions.clickElement(contactsNewModifyPage.getSaveContactButton());
    }

    @And("^I press edit contact$")
    public void iPressEditContact() {
        contactsDetailPage = new SFCDetailsPage();
        contactsDetailPage.clickEditContact();

    }
}