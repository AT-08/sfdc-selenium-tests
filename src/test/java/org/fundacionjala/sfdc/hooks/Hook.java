package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * Hook.java
 * Class to add after hook.
 */
public class Hook {

    /**
     * Method to quit browser and close webdriver for each scenario.
     */
    @After
    public void finishScenario() {
        DriverManager.getInstance().quitWebDriver();
    }
}
