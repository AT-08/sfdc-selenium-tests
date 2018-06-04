package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Then;
import org.fundacionjala.sfdc.core.driver.DriverManager;
import org.fundacionjala.sfdc.pageobjects.common.SFCommonObjects;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceEnums;
import org.fundacionjala.sfdc.util.CommonActions;
import org.fundacionjala.sfdc.util.PropertiesManager;
import org.testng.Assert;

/**
 * Common Assertions.
 */
public class CommonAssertions {
    private SFCommonObjects commonPage;

    /**
     * Constructor of common Assertions.
     *
     * @param commonPage mainPage menu.
     */
    public CommonAssertions(final SFCommonObjects commonPage) {
        this.commonPage = commonPage;
    }

    /**
     * @param nameOfObject iCanVerifyNewCreatedObject.
     * @param section      .
     */
    @Then("^I verify if \"([^\"]*)\" \"([^\"]*)\" was created/modified on Detail Page$")
    public void iVerifyIfWasCreatedModifiedOnDetailPage(final String nameOfObject,
                                                        final SalesForceEnums.EnumLocator section) {
        CommonActions.setImplicitTime(PropertiesManager.getInstance().getImplicitTime());
        Assert.assertTrue(commonPage.isWebElementPresentOnList(
                CommonActions.getNameOfObject(nameOfObject, section)));
    }

    /**
     * @param elementDeleted iVerifyThatWasDeleted.
     * @param section        .
     */
    @Then("^I verify that \"([^\"]*)\" \"([^\"]*)\" was deleted$")
    public void iVerifyThatWasDeleted(final String elementDeleted, final SalesForceEnums.EnumLocator section) {
        CommonActions.setImplicitTime(PropertiesManager.getInstance().getImplicitTime());
        Assert.assertFalse(commonPage.isWebElementPresentOnList(
                CommonActions.getNameOfObject(elementDeleted, section)));
    }
}
