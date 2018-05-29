package org.fundacionjala.sfdc.entities;


import java.util.Calendar;
import java.util.Date;
import java.util.EnumMap;
import java.util.Map;

import org.fundacionjala.sfdc.pageobjects.accounts.AccountInputs;
import org.fundacionjala.sfdc.pageobjects.campaigns.CampaignInputs;
import org.fundacionjala.sfdc.pageobjects.opportunities.OpportInputs;
import org.testng.asserts.Assertion;

/**
 * Helper class with Dependency Injection for all Steps.
 */
public class Helper {

    private String itemName = "";

    private String postMessage = "";

    private String commentPostMessage = "";

    private String campaignName = "";

    private String opportunityName = "";

    private Assertion assertion;

    private Map<AccountInputs, String> accountMap;

    private Map<CampaignInputs, String> campaignMap;

    private Map<OpportInputs, String> opportunityMap;

    private static final String REGEX_QUOTES_INSIDE = "(?<=\")(.*?)(?=\")";

    /**
     * Get the Item Name for edit and delete purposes.
     *
     * @return String.
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Set the Item Name value.
     *
     * @param itemName String.
     */
    public void setItemName(final String itemName) {
        this.itemName = concatPrefixSuffix(itemName);
    }

    /**
     * Get Post Message.
     *
     * @return String.
     */
    public String getPostMessage() {
        return postMessage;
    }

    /**
     * Set Post Message.
     *
     * @param postMessage String.
     */
    public void setPostMessage(final String postMessage) {
        this.postMessage = postMessage;
    }

    /**
     * Get Comment Post Message.
     *
     * @return String.
     */
    public String getCommentPostMessage() {
        return commentPostMessage;
    }

    /**
     * Set Comment Post Message.
     *
     * @param commentPostMessage String.
     */
    public void setCommentPostMessage(final String commentPostMessage) {
        this.commentPostMessage = concatPrefixSuffix(commentPostMessage);
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
        this.campaignName = concatPrefixSuffix(campaignName);
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
        this.opportunityName = concatPrefixSuffix(opportunityName);
    }

    /**
     * Get Assertion.
     *
     * @return a instance of Assertion.
     */
    public Assertion getAssertion() {
        return assertion;
    }

    /**
     * Set assertion instance.
     *
     * @param assertion a instance of Soft Assertion.
     */
    public void setAssertion(final Assertion assertion) {
        this.assertion = assertion;
    }

    /**
     * Get the account map.
     *
     * @return the account map object.
     */
    public Map<AccountInputs, String> getAccountMap() {
        return accountMap;
    }

    /**
     * Set the account map.
     *
     * @param accountMap is the account map.
     */
    public void setAccountMap(final Map<AccountInputs, String> accountMap) {
        this.accountMap = new EnumMap<>(accountMap);
        this.accountMap.replace(AccountInputs.ACCOUNT_NAME, getItemName());
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
        this.opportunityMap.replace(OpportInputs.OPPORTUNITY_ACCOUNT_NAME, getItemName());
    }

    /**
     * Rebuilt an asertion message, replacing the item string value in the message.
     *
     * @param msg expected message.
     * @return the rebuilt message.
     */
    public String rebuiltMessage(final String msg) {
        return msg.replaceAll(REGEX_QUOTES_INSIDE, getItemName());
    }

    /**
     * Concat a specified prefix (AT-06) and a unix timestamp suffix (in HEX representation).
     *
     * @param name the original parameter name.
     * @return the concat result.
     */
    private String concatPrefixSuffix(final String name) {
        final Date date = Calendar.getInstance().getTime();
        return name.isEmpty() ? name : String.format("%s%s%s", "AT-06", name, Long.toHexString(date.getTime()));
    }
}
