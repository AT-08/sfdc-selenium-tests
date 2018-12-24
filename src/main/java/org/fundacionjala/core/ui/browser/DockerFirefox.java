package org.fundacionjala.core.ui.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import org.fundacionjala.core.util.PropertiesInput;
import org.fundacionjala.core.util.PropertiesManager;

/**
 * DockerFirefox class.
 */
public class DockerFirefox implements Browser {
    private static final Logger LOGGER = LogManager.getLogger(DockerFirefox.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver = null;
        try {
            URL remoteAddress = new URL(PropertiesManager.getInstance().getProperties(PropertiesInput.DOCKER_URL));
            driver = new RemoteWebDriver(remoteAddress, new FirefoxOptions());
        } catch (MalformedURLException e) {
            LOGGER.error("URL bad created:", e);
        }
        return driver;
    }
}
