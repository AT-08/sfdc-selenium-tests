package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SalesForceTabClassic;
import org.fundacionjala.sfdc.pageobjects.contacts.ContactInputs;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCDetailsPage;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCMainPage;
import org.fundacionjala.sfdc.pageobjects.contacts.SFCNewModifyPage;
import org.testng.Assert;

import java.util.Map;

/**
 * ContactStepsCheck.
 */
public class ContactStepsCheck {
    private SalesForceTabClassic tabClassic = new SalesForceTabClassic();
    private SFCMainPage mainPage = new SFCMainPage();
    private SFCNewModifyPage modifyPage = new SFCNewModifyPage();
    private SFCDetailsPage detailsPage = new SFCDetailsPage();

    /**
     * iCanGoToContactSection.
     */
    @Given("^I can go to contact section$")
    public void iCanGoToContactSection() {
        tabClassic.setContactTab();
    }

    /**
     * iCanCreateANewContact.
     */
    @And("^I can create a new contact$")
    public void iCanCreateANewContact() {
        mainPage.getNewAccountButton();
    }

    /**
     * @param values iCanCreateANewContactFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can create a new contact fill the fields and press the save button$")
    public void iCanCreateANewContactFillTheFieldsAndPressTheSaveButton(final Map<ContactInputs, String> values) {
        values.keySet().stream().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

    /**
     * @param contactName iCanVerifyTheNewContact.
     */
    @Then("^I can verify the new contact \"([^\"]*)\"$")
    public void iCanVerifyTheNewContact(final String contactName) {
        Assert.assertEquals(detailsPage.getNewAccountSavedName(), contactName);

    }

    /**
     * iChooseAnContactAndPressTheEditButton.
     */
    @When("^I choose an contact and press the edit button$")
    public void iChooseAnContactAndPressTheEditButton() {
        mainPage.getAccountNameLink();
        detailsPage.getEditButton();
    }

    /**
     * iChooseAnContactAndPressTheDeleteButton.
     */
    @When("^I choose an contact and press the delete button$")
    public void iChooseAnContactAndPressTheDeleteButton() {
        mainPage.getAccountNameLink();
        detailsPage.getDeleteButton();
        detailsPage.clickDeleteAlert();
    }

    /**
     * iCanVerifyThatTheContactWasDeleted.
     */
    @Then("^I can verify that the contact was deleted$")
    public void iCanVerifyThatTheContactWasDeleted() {
        Assert.assertEquals(mainPage.getAccountHomePage(), "Home");
    }
}
