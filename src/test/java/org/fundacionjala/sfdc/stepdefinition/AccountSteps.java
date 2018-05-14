package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.Accounts.SFADetailsPage;
import org.fundacionjala.sfdc.pageobjects.Accounts.SFAMainPage;
import org.fundacionjala.sfdc.pageobjects.Accounts.SFANewModifyPage;
import org.fundacionjala.sfdc.pageobjects.SalesForceMainTabClassic;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import java.util.Map;
import java.util.Properties;

/**
 * AccountSteps.java
 * Class for steps of account.feature.
 */
public class AccountSteps {
    private WebDriver webDriver;
    private Properties propertiesManager;

    /**
     * Given step.
     */
    @Given("^Go to accounts section$")
    public void goToAccountsSection() {
        webDriver = DriverManager.getInstance().getNavigator();
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
        SFAMainPage accountsMainPage = new SFAMainPage();
        CommonActions.clickElement(accountsMainPage.getNewAccountButton());
    }

    /**
     * And step.
     */
    @And("^I fill the account name field and press the save button$")
    public void iFillTheAccountNameFieldAndPressTheSaveButton(Map<String, String> values) {
        SFANewModifyPage newAccountPage = new SFANewModifyPage();
        CommonActions.setValues(values, newAccountPage.fillMethodsToFields());
        CommonActions.clickElement(newAccountPage.getSaveNewAccountButton());
    }
    /**
     * Then step.
     */
    @Then("^a new account is created$")
    public void aNewAccountIsCreated(Map<String, String> values) {
        SFADetailsPage accountDetail = new SFADetailsPage();
        Assert.assertEquals(accountDetail.getNewAccountSavedName(), values.get("accountName"));
    }

    /**
     * When step.
     */
    @When("^I choose an account from recent accounts and I click on Edit account$")
    public void iChooseAnAccountFromRecentAccountsAndIClickOnEditAccount() {
        SFAMainPage accountsMainPage = new SFAMainPage();
        CommonActions.clickElement(accountsMainPage.getAccountNameLink());
        SFADetailsPage accountsDetailPage = new SFADetailsPage();
        CommonActions.clickElement(accountsDetailPage.getEditButton());
    }

    /**
     * And step.
     */
    @And("^I edit the account name field and I press the save button$")
    public void iEditTheAccountNameFieldAndIPressTheSaveButton() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        SFANewModifyPage modifyPage = new SFANewModifyPage();
        modifyPage.setAccountNameTextField(propertiesManager.getProperty("accountName"));
        CommonActions.clickElement(modifyPage.getSaveNewAccountButton());
    }

    /**
     * Then step.
     */
    @Then("^an account is modified")
    public void anAccountIsModified(Map<String, String> values) {
        SFADetailsPage accountDetail = new SFADetailsPage();
        Assert.assertEquals(accountDetail.getNewAccountSavedName(), values.get("accountName"));
    }

    /**
     * When step.
     */
    @When("^I choose last account from recent accounts and I click on Delete account$")
    public void iChooseLastAccountFromRecentAccountsAndIClickOnDeleteAccount() {
        SFAMainPage accountsMainPage = new SFAMainPage();
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
        SFAMainPage accountsMainPage = new SFAMainPage();
        Assert.assertEquals(accountsMainPage.getAccountHomePage(), "Home");
    }

    @And("^I fill the fields and press the save button$")
    public void iFillTheFieldsAndPressTheSaveButton(Map<String, String> values) {
        SFANewModifyPage newAccountPage = new SFANewModifyPage();
        CommonActions.setValues(values, newAccountPage.fillMethodsToFields());
        CommonActions.clickElement(newAccountPage.getSaveNewAccountButton());
    }
}
