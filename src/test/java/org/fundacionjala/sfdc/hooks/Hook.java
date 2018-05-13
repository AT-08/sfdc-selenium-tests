package org.fundacionjala.sfdc.hooks;

import cucumber.api.java.After;
import org.fundacionjala.sfdc.commons.DriverManager;

public class Hook {

    @After
    public void finishScenario() {
        DriverManager.getInstance().quitWebDriver();
    }
}
