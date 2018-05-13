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
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
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
        salesForceMainTab = new SalesForceMainTabClassic(webDriver, "a.accountBlock", "li#AllTab_Tab");
        salesForceMainTab.displayOptions();
        salesForceMainTab.goToAccounts();
    }

    /**
     * When step.
     */
    @When("^I press new account button a new account form is displayed$")
    public void iPressNewAccountButtonANewAccountFormIsDisplayed() {
        SFAMainPage accountsMainPage = new SFAMainPage();
        accountsMainPage.clickNewAccountButton();
    }

    /**
     * And step.
     */
    @And("^I fill the account name field and press the save button$")
    public void iFillTheAccountNameFieldAndPressTheSaveButton() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        SFANewModifyPage newAccountPage = new SFANewModifyPage();
        newAccountPage.setAccountNameTextField(propertiesManager.getProperty("accountName"));
        newAccountPage.clickSaveNewAccountButton();
    }
    /**
     * Then step.
     */
    @Then("^a new account is created$")
    public void aNewAccountIsCreated() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        SFADetailsPage accountDetail = new SFADetailsPage();
        System.out.println("This Step tests new account creation:" + accountDetail.getNewAccountSavedName());
        Assert.assertEquals(accountDetail.getNewAccountSavedName(), propertiesManager.getProperty("accountName"));
    }

    /**
     * When step.
     */
    @When("^I choose an account from recent accounts and I click on Edit account$")
    public void iChooseAnAccountFromRecentAccountsAndIClickOnEditAccount() {
        SFAMainPage accountsMainPage = new SFAMainPage();
        accountsMainPage.clickAccountNameLink();
        SFADetailsPage accountsDetailPage = new SFADetailsPage();
        accountsDetailPage.clickEditAccount();
    }

    /**
     * And step.
     */
    @And("^I edit the account name field and I press the save button$")
    public void iEditTheAccountNameFieldAndIPressTheSaveButton() {
        propertiesManager = PropertiesManager.getInstance().getConfig();
        SFANewModifyPage modifyPage = new SFANewModifyPage();
        modifyPage.setAccountNameTextField(propertiesManager.getProperty("accountName"));
        modifyPage.clickSaveNewAccountButton();
    }

    /**
     * When step.
     */
    @When("^I choose last account from recent accounts and I click on Delete account$")
    public void iChooseLastAccountFromRecentAccountsAndIClickOnDeleteAccount() {
        SFAMainPage accountsMainPage = new SFAMainPage();
        accountsMainPage.clickAccountNameLink();
        SFADetailsPage accountsDetailsPage = new SFADetailsPage();
        accountsDetailsPage.clickDeleteAccount();
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
    @Then("^the system delete the account$")
    public void theSystemDeleteTheAccount() {
        SFAMainPage accountsMainPage = new SFAMainPage();
        Assert.assertEquals(accountsMainPage.accountHomePage(), "Home");
    }

}
