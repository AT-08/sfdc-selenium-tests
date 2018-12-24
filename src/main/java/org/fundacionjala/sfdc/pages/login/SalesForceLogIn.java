package org.fundacionjala.sfdc.pages.login;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import org.fundacionjala.core.ui.Base;
import org.fundacionjala.core.ui.CommonWebActions;
import org.fundacionjala.core.ui.driver.DriverManager;
import org.fundacionjala.sfdc.pages.common.PageUtil;
import org.fundacionjala.sfdc.pages.components.TopMenuClassic;
import org.fundacionjala.sfdc.pages.components.TopMenuLightning;

/**
 * SalesForceLogIn.java
 * Class to log in Salesforce.
 */
public class SalesForceLogIn extends Base {
    private static final Logger LOGGER = LogManager.getLogger(SalesForceLogIn.class);


    private String url;

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement userPassword;

    @FindBy(id = "Login")
    private WebElement logInButton;

    @FindAll({
            @FindBy(css = "img#phHeaderLogoImage"),
            @FindBy(css = "div.slds-global-header__logo")
    })
    private WebElement cloudIcon;


    private TopMenuClassic topMenuClassic = new TopMenuClassic();
    private TopMenuLightning topMenuLightning = new TopMenuLightning();

    /**
     * Constructor.
     *
     * @param url the page.
     */
    public SalesForceLogIn(final String url) {
        LOGGER.info("entro");
        this.url = url;
    }

    /**
     * Setter of url attribute.
     */
    public void setWebDriverUrl() {
        DriverManager.getInstance().getDriver().get(this.url);
    }

    /**
     * Setter of userName attribute.
     *
     * @param userName string value.
     */
    public void setUserName(final String userName) {
        CommonWebActions.getElement(this.userName).sendKeys(userName);
    }

    /**
     * Setter of userPassword attribute.
     *
     * @param userPassword string value.
     */
    public void setUserPassword(final String userPassword) {
        CommonWebActions.getElement(this.userPassword).sendKeys(userPassword);
    }

    /**
     * Set the user theme.
     *
     * @param userTheme the theme from properties.
     */
    public void setUserTheme(final String userTheme) {
        String currentTheme = PageUtil.getCurrentTheme().toString();
        if (!userTheme.equalsIgnoreCase(currentTheme)) {
            if (userTheme.equalsIgnoreCase("LIGHT")) {
                topMenuClassic.switchTheme();
            } else {
                topMenuLightning.switchTheme();
            }
        }
    }

    /**
     * Getter of logInbutton.
     *
     * @return the button.
     */
    public WebElement getLogInButton() {
        return CommonWebActions.getElement(this.logInButton);
    }

    /**
     * Method to click logInButton.
     *
     * @param button to click.
     */
    public void clickLogInButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to log in Salesforce.
     *
     * @param user  the user.
     * @param pass  its password.
     * @param theme is the theme
     */
    public void logIn(final String user, final String pass, final String theme) {
        this.setWebDriverUrl();
        this.setUserName(user);
        this.setUserPassword(pass);
        WebElement button = getLogInButton();
        this.clickLogInButton(button);
        this.setUserTheme(theme);
    }

    /**
     * Method to lget icon cloud.
     *
     * @return if the icon is displayed
     */
    public boolean getCloudIcon() {
        return CommonWebActions.getElement(this.cloudIcon).isDisplayed();

    }
}
