package org.fundacionjala.sfdc.pageobjects.opportunities;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;

/**
 * SFOMainPage.
 */
public class SFOMainPage extends SFMain {

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

    @Override
    public void waitUntilPageObjectIsLoaded() {

    }
}
