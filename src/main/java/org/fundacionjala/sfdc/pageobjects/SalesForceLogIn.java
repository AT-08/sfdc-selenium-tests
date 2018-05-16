package org.fundacionjala.sfdc.pageobjects;

import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

/**
 * SalesForceLogIn.java
 * Class to log in Salesforce.
 */
public class SalesForceLogIn extends SalesForceConnection {
    private String url;

    @FindBy(how = How.ID, using = "username")
    private WebElement userName;

    @FindBy(how = How.ID, using = "password")
    private WebElement userPassword;

    @FindBy(how = How.ID, using = "Login")
    private WebElement logInButton;

    @FindBy(how = How.CSS, using = "img#phHeaderLogoImage")
    private WebElement cloudIcon;

    /**
     * Constructor.
     *
     * @param url the page.
     */
    public SalesForceLogIn(final String url) {
        this.url = url;
    }

    /**
     * Setter of url attribute.
     */
    public void setWebDriverUrl() {
        this.webDriver.get(this.url);
    }

    /**
     * Setter of userName attribute.
     *
     * @param userName string value.
     */
    public void setUserName(final String userName) {
        CommonActions.getElement(this.userName).sendKeys(userName);
    }

    /**
     * Setter of userPassword attribute.
     *
     * @param userPassword string value.
     */
    public void setUserPassword(final String userPassword) {
        CommonActions.getElement(this.userPassword).sendKeys(userPassword);
    }

    /**
     * Getter of logInbutton.
     *
     * @return the button.
     */
    public WebElement getLogInButton() {
        return CommonActions.getElement(this.logInButton);
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
     * @param user the user.
     * @param pass its password.
     */
    public void logIn(final String user, final String pass) {
        this.setWebDriverUrl();
        this.setUserName(user);
        this.setUserPassword(pass);
        WebElement button = getLogInButton();
        this.clickLogInButton(button);
    }

    /**
     * Method to lget icon cloud.
     *
     * @return if the icon is displayed
     */
    public boolean getCloudIcon() {
        return CommonActions.getElement(this.cloudIcon).isDisplayed();
    }
}

