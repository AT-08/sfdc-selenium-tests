package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;

/**
 * SFAMainPage.java
 * Class that represents the main page of accounts section.
 */
public class SFAMainPage extends SFMain {


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

    /**
     * Wait until the page loads.
     */
    @Override
    public void waitUntilPageObjectIsLoaded() {
        System.out.println("Construction.");
    }
}
