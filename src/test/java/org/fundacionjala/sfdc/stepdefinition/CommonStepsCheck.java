package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SalesForceObject;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
import org.fundacionjala.sfdc.pageobjects.accounts.SFADetailsPage;
import org.fundacionjala.sfdc.pageobjects.accounts.SFAMainPage;
import org.testng.Assert;


/**
 * AccountStepsCheck.
 */
public class CommonStepsCheck {
    private SalesForceSection tabSalesForce;
    private SFAMainPage mainPage;
    private SFADetailsPage detailsPage;

    /**
     * AccountStepsCheck.
     *
     * @param tabSalesForce tabSalesForce menu.
     * @param mainPage      mainPage menu.
     * @param detailsPage   detailsPage menu.
     */
    public CommonStepsCheck(final SalesForceSection tabSalesForce,
                            final SFAMainPage mainPage,
                            final SFADetailsPage detailsPage) {
        this.tabSalesForce = tabSalesForce;
        this.mainPage = mainPage;
        this.detailsPage = detailsPage;
    }

    /**
     * iCanGoToSection.
     * @param section section to go.
     */
    @Given("^I can go to \"([^\"]*)\" Section")
    public void iCanGoToSection(final SalesForceObject section) {
        tabSalesForce.goToSalesForceTab(section);
    }

    /**
     * iCanCreateANewAccount.
     */
    @When("^I can click on New button$")
    public void iCanClickOnNewButton() {
        mainPage.clickToNewButton();
    }

    /**
     * @param nameOfObject iCanVerifyNewCreatedObject.
     */
    @Then("^I can verify if \"([^\"]*)\" has been created$")
    public void iCanVerifyNewCreatedObject(final String nameOfObject) {
        Assert.assertEquals(detailsPage.getNewAccountSavedName(), nameOfObject);
    }

    /**
     * iChooseAnAccount.
     */
    @When("^I choose an account$")
    public void iChooseAnAccount() {
        mainPage.clickAccountNameLink();
    }

    /**
     * iChooseAnAccountAndPressTheEditButton.
     */
    @When("^I click on edit button to new account created$")
    public void iChooseAnAccountAndPressTheEditButton() {
        detailsPage.clickEditButton();
    }

    /**
     * iChooseAnAccountAndPressTheDeleteButton.
     */
    @When("^I choose an account and press the delete button$")
    public void iChooseAnAccountAndPressTheDeleteButton() {
        mainPage.clickAccountNameLink();
        detailsPage.clickDeleteButton();
        detailsPage.clickDeleteAlert();
    }

    /**
     * iCanVerifyThatTheAccountWasDeleted.
     */
    @Then("^I can verify that the account was deleted$")
    public void iCanVerifyThatTheAccountWasDeleted() {
        Assert.assertEquals(mainPage.getAccountHomePage(), "home");
    }
}
