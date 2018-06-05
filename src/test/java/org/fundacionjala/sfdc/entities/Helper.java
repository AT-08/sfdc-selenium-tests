package org.fundacionjala.sfdc.entities;


import org.fundacionjala.sfdc.pageobjects.campaigns.CampaignInputs;
import org.fundacionjala.sfdc.pageobjects.opportunities.OpportInputs;

import java.util.EnumMap;
import java.util.Map;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String accountName;
    private String campaignName;
    private String opportunityName;
    private String contactName;
    private Map<CampaignInputs, String> campaignMap;
    private Map<OpportInputs, String> opportunityMap;

    /**
     * Get the Contact Name for  delete purposes.
     *
     * @return String.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * Set the Contact Name value.
     *
     * @param contactName String.
     */
    public void setContactName(final String contactName) {
        this.contactName = contactName;
    }

    /**
     * Get the Account Name for edit and delete purposes.
     *
     * @return String.
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * Set the Item Name value.
     *
     * @param accountName String.
     */
    public void setAccountName(final String accountName) {
        this.accountName = accountName;
    }

    /**
     * Get Campaign Name.
     *
     * @return String.
     */
    public String getCampaignName() {
        return campaignName;
    }

    /**
     * Set Account Name.
     *
     * @param campaignName String.
     */
    public void setCampaignName(final String campaignName) {
        this.campaignName = campaignName;
    }

    /**
     * Get Opportunity Name.
     *
     * @return String.
     */
    public String getOpportunityName() {
        return opportunityName;
    }

    /**
     * Set Opportunity Name.
     *
     * @param opportunityName String.
     */
    public void setOpportunityName(final String opportunityName) {
        this.opportunityName = opportunityName;
    }

    /**
     * Get the campaign map.
     *
     * @return the campaign map object.
     */
    public Map<CampaignInputs, String> getCampaignMap() {
        return campaignMap;
    }

    /**
     * Set the campaign map.
     *
     * @param campaignMap is the campaign map.
     */
    public void setCampaignMap(final Map<CampaignInputs, String> campaignMap) {
        this.campaignMap = new EnumMap<>(campaignMap);
        this.campaignMap.replace(CampaignInputs.CAMPAIGN_NAME, getCampaignName());
    }

    /**
     * Get the opportunity map.
     *
     * @return the opportunity map object.
     */
    public Map<OpportInputs, String> getOpportunityMap() {
        return opportunityMap;
    }

    /**
     * Set the opportunity map.
     *
     * @param opportunityMap is the opportunity map.
     */
    public void setOpportunityMap(final Map<OpportInputs, String> opportunityMap) {
        this.opportunityMap = new EnumMap<>(opportunityMap);
        this.opportunityMap.replace(OpportInputs.OPPORTUNITY_NAME, getOpportunityName());
        this.opportunityMap.replace(OpportInputs.OPPORTUNITY_PRIMARY_CAMPAIGN_SOURCE, getCampaignName());
        this.opportunityMap.replace(OpportInputs.OPPORTUNITY_ACCOUNT_NAME, getAccountName());
    }

}
