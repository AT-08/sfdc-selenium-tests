package org.fundacionJala.sfdc.pageObjects;

import org.openqa.selenium.WebDriver;
import java.util.Properties;
import org.fundacionJala.sfdc.commons.DriverManager;
import org.fundacionJala.sfdc.commons.PropertiesManager;

/**
 * Main.java
 * Class to run project by itself.
 */
public final class Main {
    /**
     * Constructor.
     */
    private Main() {
    }

    /**
     * Main method.
     * @param args from cmd execution.
     */
    public static void main(final String[] args) {
        WebDriver driver;
        Properties prop;

        driver = DriverManager.getInstance().getNavigator();
        SalesForceLogIn salesForceLogIn = new SalesForceLogIn(driver, "https://login.salesforce.com/");

        prop = PropertiesManager.getInstance().getConfig();
        salesForceLogIn.logIn(prop.getProperty("user"), prop.getProperty("password"));

    }
}
