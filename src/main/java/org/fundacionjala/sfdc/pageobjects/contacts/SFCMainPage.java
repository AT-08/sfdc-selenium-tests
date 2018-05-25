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
