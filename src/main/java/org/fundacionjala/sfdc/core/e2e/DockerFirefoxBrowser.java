package org.fundacionjala.sfdc.core.e2e;

import org.fundacionjala.sfdc.util.PropertiesManager;
import org.fundacionjala.sfdc.util.RunTimeExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerFirefoxBrowser class.
 */
public class DockerFirefoxBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesManager.getInstance().getDockerUrl()), new FirefoxOptions());
        } catch (MalformedURLException e) {
            String message = "URL bad created";
            throw new RunTimeExceptions(message, e);
        }
        return driver;
    }
}
