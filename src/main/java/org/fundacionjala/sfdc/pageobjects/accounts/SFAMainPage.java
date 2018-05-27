package org.fundacionjala.sfdc.pageobjects.accounts;

import org.fundacionjala.sfdc.pageobjects.SFMain;
import org.fundacionjala.sfdc.util.CommonActions;

/**
 * SFAMainPage.java
 * Class that represents the main page of accounts section.
 */
public class SFAMainPage extends SFMain {


    /**
     * clickToNewButton.
     */
    @Override
    public void clickToNewButton() {
        CommonActions.clickElement(this.newButton);
    }

    /**
     * clickAccountNameLink.
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
