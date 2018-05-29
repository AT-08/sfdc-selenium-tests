package org.fundacionjala.sfdc.hooks;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import org.fundacionjala.sfdc.entities.Helper;


/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private SalesForceSection tabSalesForce;
    private SFDetails detailsPage;
    private SFMain mainPage;
    private Helper helper;

    /**
     * Default Constructor.
     *
     * @param helper Helper.
     */
    public Hooks(final Helper helper) {
        this.helper = helper;
        tabSalesForce = new SalesForceSection();
        detailsPage = new SFDetails();
        mainPage = new SFMain();
    }

    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount")
    public void deleteCreatedAccount() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.ACCOUNT);
        mainPage.clickElementOnList(helper.getItemName());
        detailsPage.clickDeleteButton();
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign")
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
}
