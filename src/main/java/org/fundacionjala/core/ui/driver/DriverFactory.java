package org.fundacionjala.core.ui.driver;

import java.util.EnumMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import org.fundacionjala.core.ui.browser.Browser;
import org.fundacionjala.core.ui.browser.BrowserStack;
import org.fundacionjala.core.ui.browser.Chrome;
import org.fundacionjala.core.ui.browser.DockerChrome;
import org.fundacionjala.core.ui.browser.DockerFirefox;
import org.fundacionjala.core.ui.browser.Firefox;
import org.fundacionjala.core.ui.browser.SauceLabs;

/**
 * Class created in order to recognize the org.fundacionjala.core.ui.driver type.
 */
public final class DriverFactory {

    /**
     * Private Constructor for the DriverFactory utility class.
     */
    private DriverFactory() {
    }

    /**
     * Return the WebDriver instance specified by the environment properties.
     *
     * @param driverType Enum value specified from DriverType.
     * @return a WebDriver instance.
     */
    public static WebDriver getDriverManager(final DriverType driverType) {
        Map<DriverType, Browser> map = new EnumMap<>(DriverType.class);
        map.put(DriverType.CHROME, new Chrome());
        map.put(DriverType.FIREFOX, new Firefox());
        map.put(DriverType.DOCKER_CHROME, new DockerChrome());
        map.put(DriverType.DOCKER_FIREFOX, new DockerFirefox());
        map.put(DriverType.SAUCELABS, new SauceLabs());
        map.put(DriverType.BROWSER_STACK, new BrowserStack());
        return map.get(driverType).getBrowser();
    }
}
