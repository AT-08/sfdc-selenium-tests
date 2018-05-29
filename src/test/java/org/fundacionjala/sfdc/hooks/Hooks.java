package org.fundacionjala.sfdc.hooks;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;


import org.fundacionjala.sfdc.entities.Helper;


/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    SalesForceSection tabSalesForce;
    SFDetails detailsPage;
    SFMain mainPage;
    private Helper helper;

    /**
     * Default Constructor.
     *
     * @param helper Helper.
     */
    public Hooks(final Helper helper) {
        this.helper = helper;
    }

    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount", order = 5)
    public void deleteCreatedAccount() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.ACCOUNT);
        mainPage.clickElementOnList(helper.getItemName());
        detailsPage.clickDeleteButton();
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign", order = 7)
    public void deleteCreatedItemCampaign() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.CAMPAIGN);
        mainPage.clickElementOnList(helper.getCampaignName());
        detailsPage.clickDeleteButton();
    }

    /**
     * Takes a snapshot when a scenario fails.
     *
     * @param scenario variable for Cucumber features.
     */
    @After
    public void takeScreenShot(final Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) DriverManager.getInstance().getNavigator())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.embed(screenshot, "image/png");
        }
    }

    /**
     * Set a instance of Soft Assert to helper.
     */
    @Before(value = "@SoftAssert", order = 10)
    public void setSoftAssertion() {
        helper.setAssertion(new SoftAssert());
    }

    /**
     * Set a instance of Hard Assert to helper.
     */
    @Before(order = 1)
    public void setHardAssertion() {
        helper.setAssertion(new Assertion());
    }

}

