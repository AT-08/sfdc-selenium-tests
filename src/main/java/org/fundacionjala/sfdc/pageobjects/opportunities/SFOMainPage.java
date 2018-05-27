package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;

/**
 * SFCampMainPage.
 */
public class SFOMainPage extends SFMain {

    /**
     * getNewAccountButton.
     */
    @Override
    public void clickToNewButton() {
        CommonActions.clickElement(this.newButton);
    }

    /**
     * getAccountNameLink.
     */
    @Override
    public void clickAccountNameLink() {
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
