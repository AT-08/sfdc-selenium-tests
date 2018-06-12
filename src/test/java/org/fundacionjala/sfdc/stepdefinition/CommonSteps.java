package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.common.SFCommonObjects;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceSection;
import org.fundacionjala.sfdc.util.CommonActions;

import static org.fundacionjala.core.util.CommonWebActions.resetWaitTime;
import static org.fundacionjala.core.util.CommonWebActions.waitTime;

/**
 * Common Steps.
 */
public class CommonSteps {
    private SalesForceSection tabSalesForce;
    private SFCommonObjects commonPage;

    /**
     * Constructor of common steps.
     *
     * @param tabSalesForce tabSalesForce menu.
     * @param commonPage    commonPage menu.
     */
    public CommonSteps(final SalesForceSection tabSalesForce,
                       final SFCommonObjects commonPage) {
        this.tabSalesForce = tabSalesForce;
        this.commonPage = commonPage;
    }

    /**
     * iCanGoToSection.
     *
     * @param section section to go.
     */
    @And("^I go to \"([^\"]*)\" Section$")
    public void iGoToSection(final SalesForceEnums.EnumLocator section) {
        tabSalesForce.goToSalesForceTab(section);
    }

    /**
     * iCreateANewAccount.
     */
    @When("^I click on New button$")
    public void iClickOnNewButton() {
        commonPage.clickToNewButton();
    }

    /**
     * iChooseLastElementOnList.
     *
     * @param elementOnList .
     */
    @When("^I click on \"([^\"]*)\" at list on Main Page")
    public void iChooseLastElementOnList(final String elementOnList) {
        final int time = 3;
        waitTime(time);
        commonPage.clickElementOnList(elementOnList);
        resetWaitTime();
    }

    /**
     * iChooseLastElementOnList.
     */
    @When("I click on Edit Button")
    public void iClickOnEditButton() {
        commonPage.clickEditButton();
    }

    /**
     * iClickOnDeleteButton.
     */
    @When("I click on Delete Button")
    public void iClickOnDeleteButton() {
        commonPage.clickDeleteButton();
    }

    /**
     * @param nameOfObject iClickOnAtListOnMainPage.
     * @param section      .
     */
    @And("^I click on \"([^\"]*)\" \"([^\"]*)\" at list on Main Page$")
    public void iClickOnAtListOnMainPage(final String nameOfObject, final SalesForceEnums.EnumLocator section) {
        commonPage.clickElementOnList(CommonActions.getNameOfObject(nameOfObject, section));
    }

    /**
     * iCanClickOnEditButtonAtListOnMainPage(Second way).
     *
     * @param objectName object Name.
     */
    @And("^I edit \"([^\"]*)\" at list on Main Page$")
    public void iEditAtListOnMainPage(final String objectName) {
        commonPage.clickEditSecondWay(objectName);
    }

    /**
     * iCanClickOnDeleteButtonAtListOnMainPage(Second way).
     *
     * @param objectName object Name.
     */
    @And("^I delete \"([^\"]*)\" at list on Main Page$")
    public void iDeleteAtListOnMainPage(final String objectName) {
        commonPage.clickDeleteSecondWay(objectName);
    }

}
