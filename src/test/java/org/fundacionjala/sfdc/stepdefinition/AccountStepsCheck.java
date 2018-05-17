package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SalesForceTabClassic;
import org.fundacionjala.sfdc.pageobjects.accounts.AccountInputs;
import org.fundacionjala.sfdc.pageobjects.accounts.SFADetailsPage;
import org.fundacionjala.sfdc.pageobjects.accounts.SFAMainPage;
import org.fundacionjala.sfdc.pageobjects.accounts.SFANewModifyPage;
import org.testng.Assert;

import java.util.Map;

/**
 * AccountStepsCheck.
 */
public class AccountStepsCheck {
    private SalesForceTabClassic tabClassic = new SalesForceTabClassic();
    private SFAMainPage mainPage = new SFAMainPage();
    private SFANewModifyPage modifyPage = new SFANewModifyPage();
    private SFADetailsPage detailsPage = new SFADetailsPage();

    /**
     * iCanGoToAccountSection.
     */
    @Given("^I can go to account section$")
    public void iCanGoToAccountSection() {
        tabClassic.setAccountTab();
    }

    /**
     * iCanCreateANewAccount.
     */
    @And("^I can create a new account$")
    public void iCanCreateANewAccount() {
        mainPage.getNewAccountButton();
    }

    /**
     * @param values iCanCreateANewAccountFillTheFieldsAndPressTheSaveButton.
     */
    @And("^I can create a new account fill the fields and press the save button$")
    public void iCanCreateANewAccountFillTheFieldsAndPressTheSaveButton(final Map<AccountInputs, String> values) {
        values.keySet().stream().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        modifyPage.getSaveNewAccountButton();
    }

    /**
     * @param accountName iCanVerifyTheNewAccount.
     */
    @Then("^I can verify the new account \"([^\"]*)\"$")
    public void iCanVerifyTheNewAccount(final String accountName) {
        Assert.assertEquals(detailsPage.getNewAccountSavedName(), accountName);
    }

    /**
     * iChooseAnAccount.
     */
    @When("^I choose an account$")
    public void iChooseAnAccount() {
        mainPage.getAccountNameLink();
    }

    /**
     * iChooseAnAccountAndPressTheEditButton.
     */
    @When("^I choose an account and press the edit button$")
    public void iChooseAnAccountAndPressTheEditButton() {
        mainPage.getAccountNameLink();
        detailsPage.getEditButton();
    }

    /**
     * iChooseAnAccountAndPressTheDeleteButton.
     */
    @When("^I choose an account and press the delete button$")
    public void iChooseAnAccountAndPressTheDeleteButton() {
        mainPage.getAccountNameLink();
        detailsPage.getDeleteButton();
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
