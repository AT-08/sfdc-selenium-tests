package org.fundacionjala.sfdc.pageobjects.campaigns;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;

/**
 * SFCampMainPage.
 */
public class SFCampMainPage extends SFMain {

    /**
     * getNewAccountButton.
     */
    @Override
    public void getNewAccountButton() {
        CommonActions.clickElement(this.newButton);
    }

    /**
     * getAccountNameLink.
     */
    @Override
    public void getAccountNameLink() {
        CommonActions.clickElement(this.lastItemOnList);
    }

    /**
     * @return getAccountHomePage.
     */
    @Override
    public String getAccountHomePage() {
        return CommonActions.getTextElement(this.homeContact);
    }

}
