package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.commons.PropertiesManager;
import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
import org.testng.Assert;


/**
 * AccountSteps.
 */
public class CommonSteps {
    private static final boolean IS_CLASSIC = PropertiesManager.getInstance().getTheme().equalsIgnoreCase("classic");
    private SalesForceSection tabSalesForce;
    private SFMain mainPage;
    private SFDetails detailsPage;

    /**
     * AccountSteps.
     *
     * @param tabSalesForce tabSalesForce menu.
     * @param mainPage      mainPage menu.
     * @param detailsPage   detailsPage menu.
     */
    public CommonSteps(final SalesForceSection tabSalesForce,
                       final SFMain mainPage,
                       final SFDetails detailsPage) {
        this.tabSalesForce = tabSalesForce;
        this.mainPage = mainPage;
        this.detailsPage = detailsPage;
    }

    /**
     * iCanGoToSection.
     *
     * @param section section to go.
     */
    @Given("^I can go to \"([^\"]*)\" Section")
    public void iCanGoToSection(final SalesForceEnums.EnumLocator section) {
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
     * iChooseLastElementOnList.
     */
    @When("I can click on Edit Button")
    public void iCanClickOnEditButton() {
        detailsPage.clickEditButton();
    }

    /**
     * iCanClickOnDeleteButton.
     */
    @When("I can click on Delete Button")
    public void iCanClickOnDeleteButton() {
        detailsPage.clickDeleteButton();
    }

    /**
     * iCanConfirmDeleteAlert.
     */
    @When("I can confirm Delete alert")
    public void iCanConfirmDeleteAlert() {
        detailsPage.clickDeleteAlert();
    }

    /**
     * iCanVerifyThatTheAccountWasDeleted.
     *
     * @param elementDeleted .
     * @param section        .
     */
    @Then("^I can verify that \"([^\"]*)\" was deleted$")
    public void iCanVerifyThatTheAccountWasDeleted(final String elementDeleted,
                                                   final SalesForceEnums.EnumLocator section) {
        Assert.assertNull(mainPage.getElementOnList(elementDeleted, section));
    }

    /**
     * @param nameOfObject iCanVerifyNewCreatedObject.
     * @param section      .
     */
    @And("^I can verify if \"([^\"]*)\" \"([^\"]*)\" was created/modified on Detail Page$")
    public void iCanVerifyIfWasCreatedModifiedOnDetailPage(final String nameOfObject,
                                                           final SalesForceEnums.EnumLocator section) {
        if (IS_CLASSIC) {
            Assert.assertNotNull(mainPage.getElementOnList(nameOfObject, section));
        } else {
            Assert.assertTrue(mainPage.getConfirmMessageShowed(nameOfObject).contains(nameOfObject));
            Assert.assertNotNull(mainPage.getElementOnList(nameOfObject, section));
        }

    }

    /**
     * @param nameOfObject iCanClickOnAtListOnMainPage.
     * @param section      .
     */
    @And("^I can click on \"([^\"]*)\" \"([^\"]*)\" at list on Main Page$")
    public void iCanClickOnAtListOnMainPage(final String nameOfObject, final SalesForceEnums.EnumLocator section) {
        mainPage.clickElementOnList(nameOfObject, section);
    }

    /**
     * @param elementDeleted iCanVerifyThatWasDeleted.
     * @param section        .
     */
    @Then("^I can verify that \"([^\"]*)\" \"([^\"]*)\" was deleted$")
    public void iCanVerifyThatWasDeleted(final String elementDeleted, final SalesForceEnums.EnumLocator section) {
        Assert.assertNull(mainPage.getElementOnList(elementDeleted, section));
    }

    /**
     * iCanClickOnDeleteButtonAtListOnMainPage(Second way).
     */
    @When("^I can click on Delete Button at list on Main Page$")
    public void iCanClickOnDeleteButtonAtListOnMainPage() {
        detailsPage.clickDeleteSecondWay();
    }

    /**
     * iCanClickOnDeleteButtonAtListOnMainPage(Second way).
     */
    @And("^I can click on Edit Button at list on Main Page$")
    public void iCanClickOnEditButtonAtListOnMainPage() {
        detailsPage.clickEditSecondWay();
    }
}
