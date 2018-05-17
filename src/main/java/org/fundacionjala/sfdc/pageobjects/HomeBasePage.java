package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.pageobjects.components.TopMenu;

/**
 * Home base page for page objects.
 */
public abstract class HomeBasePage extends Base {
    private TopMenu topMenu;

    /**
     * Constructor method.
     */
    public HomeBasePage() {
        this.topMenu = PageFactory.getTopMenu();
    }

    /**
     * Get the top menu.
     *
     * @return topmenu.
     */
    public TopMenu getTopMenu() {
        return topMenu;
    }

    /**
     * Set the top menu.
     *
     * @param topMenu topmenu.
     */
    public void setTopMenu(final TopMenu topMenu) {
        this.topMenu = topMenu;
    }
}
