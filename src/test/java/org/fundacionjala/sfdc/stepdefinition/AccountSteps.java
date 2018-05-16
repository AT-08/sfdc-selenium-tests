package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.accounts.SFADetailsPage;
import org.fundacionjala.sfdc.pageobjects.accounts.SFAMainPage;
import org.fundacionjala.sfdc.pageobjects.accounts.SFANewModifyPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.Inputs;
import org.testng.Assert;

import java.util.Map;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class AccountSteps {
    private SFANewModifyPage newAccountPage = new SFANewModifyPage();
    private SFAMainPage accountsMainPage = new SFAMainPage();
    private SFADetailsPage accountDetail = new SFADetailsPage();

    /**
     * Given step.
     */
    @Given("^Go to accounts section$")
    public void goToAccountsSection() {
        SalesForceMainTabClassic salesForceMainTab;
        salesForceMainTab = new SalesForceMainTabClassic("a.accountBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I press new account button a new account form is displayed$")
    public void iPressNewAccountButtonANewAccountFormIsDisplayed() {
        CommonActions.clickElement(accountsMainPage.getNewAccountButton());
    }

    /**
     * And step.
     *
     * @param accountName account Name.
     */
    @Then("^a new account is created \"([^\"]*)\"$")
    public void aNewAccountIsCreated(final String accountName) {
        Assert.assertEquals(accountDetail.getNewAccountSavedName(), accountName);
    }

    /**
     * When step.
     */
    @When("^I choose an account from recent accounts and I execute action$")
    public void iChooseAnAccountFromRecentAccountsAndIExecuteAction() {
        CommonActions.clickElement(accountsMainPage.getAccountNameLink());
        SFADetailsPage accountsDetailPage = new SFADetailsPage();
        CommonActions.clickElement(accountsDetailPage.getEditButton());
    }

    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I edit the account name field and I press the save button$")
    public void iEditTheAccountNameFieldAndIPressTheSaveButton(final Map<Inputs, String> values) {
        SFANewModifyPage modifyPage = new SFANewModifyPage();
        values.keySet().stream().forEach(step -> modifyPage.getStrategyStepMap(values).get(step).fillField());
        CommonActions.clickElement(modifyPage.getSaveNewAccountButton());
    }

    /**
     * When step.
     */
    @When("^I choose last account from recent accounts and I click on Delete account$")
    public void iChooseLastAccountFromRecentAccountsAndIClickOnDeleteAccount() {
        CommonActions.clickElement(accountsMainPage.getAccountNameLink());
        SFADetailsPage accountsDetailsPage = new SFADetailsPage();
        CommonActions.clickElement(accountsDetailsPage.getDeleteButton());
    }

    /**
     * Then step.
     */
    @And("^I click on OK$")
    public void iClickOnOK() {
        SFADetailsPage accountsDetailsPage = new SFADetailsPage();
        accountsDetailsPage.clickDeleteAlert();
    }

    /**
     * Then step.
     */
    @Then("^the system deletes the account$")
    public void theSystemDeletesTheAccount() {
        Assert.assertEquals(accountsMainPage.getAccountHomePage(), "Home");
    }

    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I fill the fields and press the save button$")
    public void iFillTheFieldsAndPressTheSaveButton(final Map<Inputs, String> values) {
        values.keySet().stream().forEach(step -> newAccountPage.getStrategyStepMap(values).get(step).fillField());
        CommonActions.clickElement(newAccountPage.getSaveNewAccountButton());
    }

    /**
     * And step.
     *
     * @param values map.
     */
    @And("^I create a new account$")
    public void iCreateANewAccount(final Map<Inputs, String> values) {
        goToAccountsSection();
        iPressNewAccountButtonANewAccountFormIsDisplayed();
        iFillTheFieldsAndPressTheSaveButton(values);
    }
}
