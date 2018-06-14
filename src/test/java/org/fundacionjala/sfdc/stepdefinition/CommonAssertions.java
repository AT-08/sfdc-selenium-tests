package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.Then;
import org.fundacionjala.core.selenium.CommonWebActions;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pageobjects.common.SFCommonObjects;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceEnums;
import org.fundacionjala.sfdc.util.CommonActions;
import org.testng.Assert;

/**
 * Common Assertions.
 */
public class CommonAssertions {
    private SFCommonObjects commonPage;
    private Helper helperToHook;

    /**
     * Constructor of common Assertions.
     *
     * @param commonPage mainPage menu.
     */
    public CommonAssertions(final SFCommonObjects commonPage, final Helper helperToHook) {
        this.commonPage = commonPage;
        this.helperToHook = helperToHook;
    }

    /**
     * @param nameOfObject iCanVerifyNewCreatedObject.
     * @param section      .
     */
    @Then("^I verify if \"([^\"]*)\" \"([^\"]*)\" was created/modified on Detail Page$")
    public void iVerifyIfWasCreatedModifiedOnDetailPage(final String nameOfObject,
                                                        final SalesForceEnums.EnumLocator section) {
        //CommonWebActions.waitTime(1);
        Assert.assertTrue(commonPage.isWebElementPresentOnList(
                CommonActions.getNameOfObject(nameOfObject, section)));
        CommonWebActions.waitTime(3);
    }

    /**
     * @param elementDeleted iVerifyThatWasDeleted.
     * @param section        .
     */
    @Then("^I verify that \"([^\"]*)\" \"([^\"]*)\" was deleted$")
    public void iVerifyThatWasDeleted(final String elementDeleted, final SalesForceEnums.EnumLocator section) {
        CommonWebActions.waitTime(2);
        Assert.assertFalse(commonPage.isWebElementPresentOnList(
        CommonActions.getNameOfObject(elementDeleted, section)));
    }
}
