package org.fundacionjala.sfdc.hooks;


import cucumber.api.java.After;
import org.fundacionjala.sfdc.entities.Helper;
import org.fundacionjala.sfdc.pageobjects.common.SFCommonObjects;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceEnums;
import org.fundacionjala.sfdc.pageobjects.common.SalesForceSection;


/**
 * Hooks Class for actions to run before and after Scenarios.
 */
public class Hooks {

    private SalesForceSection tabSalesForce;
    private SFCommonObjects detailsPage;
    private Helper helper;

    /**
     * Default Constructor.
     *
     * @param helper        Helper.
     * @param tabSalesForce tabs.
     * @param detailsPage   commmon objects.
     */
    public Hooks(final Helper helper, final SalesForceSection tabSalesForce, final SFCommonObjects detailsPage) {
        this.helper = helper;
        this.tabSalesForce = tabSalesForce;
        this.detailsPage = detailsPage;
    }


    /**
     * Delete Account.
     */
    @After(value = "@deleteAccount")
    public void deleteCreatedAccount() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.ACCOUNT);
        detailsPage.clickDeleteSecondWay(helper.getAccountName());
    }

    /**
     * Delete Campaign.
     */
    @After(value = "@deleteCampaign")
    public void deleteCreatedItemCampaign() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.CAMPAIGN);
        detailsPage.clickDeleteSecondWay(helper.getCampaignName());
    }

    /**
     * Delete Contact.
     */
    @After(value = "@deleteContact")
    public void deleteContact() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.CONTACT);
        detailsPage.clickDeleteSecondWay(helper.getContactName());
    }

    /**
     * Delete Opportunity.
     */
    @After(value = "@deleteOpportunity")
    public void deleteOpportunity() {
        tabSalesForce.goToSalesForceTab(SalesForceEnums.EnumLocator.OPPORTUNITY);
        detailsPage.clickDeleteSecondWay(helper.getOpportunityName());
    }
}
