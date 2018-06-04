package org.fundacionjala.sfdc.core.driver;

import org.fundacionjala.sfdc.util.PropertiesManager;
import org.fundacionjala.sfdc.util.RunTimeExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerChromeBrowser class.
 */
public class DockerChromeBrowser implements Browser {

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesManager.getInstance().getDockerUrl()), new ChromeOptions());
        } catch (MalformedURLException e) {
            String message = "URL bad created";
            throw new RunTimeExceptions(message, e);
        }
        return driver;
    }
}
