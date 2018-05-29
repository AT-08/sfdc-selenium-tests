package org.fundacionjala.sfdc.stepdefinition;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fundacionjala.sfdc.pageobjects.SFDetails;
import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.pageobjects.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.SalesForceSection;
import org.fundacionjala.sfdc.util.CommonActions;
import org.testng.Assert;

/**
 * AccountSteps.
 */
public class CommonSteps {
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
     * <<<<<<< FIXES
     *
     * @param nameOfObject iCanVerifyNewCreatedObject.
     */
    @Then("^I can verify if \"([^\"]*)\" was created/modified on Detail Page$")
    public void iCanVerifyNewCreatedObject(final String nameOfObject) {
        CommonActions.waitTime(2);
        Assert.assertTrue(mainPage.istWebElementPresentOnList(nameOfObject));
        CommonActions.resetWaitTime();
    }

    /**
     * iChooseLastElementOnList.
     *
     * @param elementOnList .
     */
    @When("^I can click on \"([^\"]*)\" at list on Main Page")
    public void iChooseLastElementOnList(final String elementOnList) {
        final int time = 3;
        CommonActions.waitTime(time);
        mainPage.clickElementOnList(elementOnList);
        CommonActions.resetWaitTime();
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
     * @param nameOfObject iCanVerifyNewCreatedObject.
     * @param section      .
     */
    @And("^I can verify if \"([^\"]*)\" \"([^\"]*)\" was created/modified on Detail Page$")
    public void iCanVerifyIfWasCreatedModifiedOnDetailPage(final String nameOfObject,
                                                           final SalesForceEnums.EnumLocator section) {
        if (SalesForceEnums.EnumLocator.CONTACT.equals(section)) {
            Assert.assertTrue(mainPage.istWebElementPresentOnList(CommonActions.formatContactName(nameOfObject)));
        } else {
            Assert.assertTrue(mainPage.istWebElementPresentOnList(nameOfObject));
        }

    }

    /**
     * @param nameOfObject iCanClickOnAtListOnMainPage.
     * @param section      .
     */
    @And("^I can click on \"([^\"]*)\" \"([^\"]*)\" at list on Main Page$")
    public void iCanClickOnAtListOnMainPage(final String nameOfObject, final SalesForceEnums.EnumLocator section) {
        if (SalesForceEnums.EnumLocator.CONTACT.equals(section)) {
            mainPage.clickElementOnList(CommonActions.formatContactName(nameOfObject));
        } else {
            mainPage.clickElementOnList(nameOfObject);
        }
    }

    /**
     * @param elementDeleted iCanVerifyThatWasDeleted.
     * @param section        .
     */
    @Then("^I can verify that \"([^\"]*)\" \"([^\"]*)\" was deleted$")
    public void iCanVerifyThatWasDeleted(final String elementDeleted, final SalesForceEnums.EnumLocator section) {
        CommonActions.waitTime(2);
        if (SalesForceEnums.EnumLocator.CONTACT.equals(section)) {
            Assert.assertFalse(mainPage.istWebElementPresentOnList(CommonActions.formatContactName(elementDeleted)));
        } else {
            Assert.assertFalse(mainPage.istWebElementPresentOnList(elementDeleted));
        }
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
