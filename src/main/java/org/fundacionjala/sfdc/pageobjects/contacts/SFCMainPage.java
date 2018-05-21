package org.fundacionjala.sfdc.pageobjects.contacts;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;


/**
 * SFCMainPage.java
 * Class that represents the main page of contacts section.
 */
public class SFCMainPage extends SFMain {

    /**
     * getNewAccountButton.
     */
    @Override
    public void getNewAccountButton() {
        CommonActions.clickElement(this.newContactButton);
    }

    /**
     * getAccountNameLink.
     */
    @Override
    public void getAccountNameLink() {
        CommonActions.clickElement(this.lastContactLink);
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
