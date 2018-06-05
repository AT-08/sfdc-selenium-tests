package org.fundacionjala.sfdc.core.driver;

import org.apache.log4j.Logger;
import org.fundacionjala.sfdc.util.PropertiesManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * DockerChromeBrowser class.
 */
public class DockerChromeBrowser implements Browser {
    private static final Logger log = Logger.getLogger(DockerChromeBrowser.class.getName());

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            driver = new RemoteWebDriver(new URL(PropertiesManager.getInstance().getDockerUrl()), new ChromeOptions());
        } catch (MalformedURLException e) {
            log.error("URL bad created:", e);
        }
        return driver;
    }
}
