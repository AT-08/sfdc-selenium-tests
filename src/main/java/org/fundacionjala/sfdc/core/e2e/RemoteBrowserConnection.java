package org.fundacionjala.sfdc.core.e2e;

import org.fundacionjala.sfdc.util.PropertiesManager;
import org.fundacionjala.sfdc.util.RunTimeExceptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * This abstract class implements methods to use in SauceLabs and Browser Stack connection.
 */
public abstract class RemoteBrowserConnection implements Browser {
    protected static final PropertiesManager PROPERTIES_MANAGER = PropertiesManager.getInstance();
    protected static final String USERNAME = PROPERTIES_MANAGER.getRemoteUserName();
    protected static final String ACCESS_KEY = PROPERTIES_MANAGER.getRemoteAccessKey();
    private final String url;

    /**
     * This method setCapabilities the remote browser.
     *
     * @return DesiredCapabilities instance.
     */
    abstract DesiredCapabilities setCapabilities();

    /**
     * This is the constructor.
     *
     * @param url url connection.
     */
    public RemoteBrowserConnection(final String url) {
        this.url = url;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebDriver getBrowser() {
        WebDriver driver;
        try {
            driver = new RemoteWebDriver(new URL(url), setCapabilities());
        } catch (MalformedURLException e) {
            throw new RunTimeExceptions("URL bad created:", e);
        }
        return driver;
    }

}
