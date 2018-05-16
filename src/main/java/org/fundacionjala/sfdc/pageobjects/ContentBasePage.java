package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.pageobjects.components.TopMenu;

public abstract class ContentBasePage extends SalesForceConnection {
    TopMenu topMenu;
    public ContentBasePage() {
        this.topMenu = PageFactory.getTopMenu();
//        waitUntilPageObjectIsLoaded();
    }
}
