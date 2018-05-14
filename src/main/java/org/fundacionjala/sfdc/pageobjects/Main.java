package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.WebDriver;
import java.util.Properties;
import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.commons.PropertiesManager;

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
