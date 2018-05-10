package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * SalesForceLogIn.java
 * Class to log in Salesforce.
 */
public class SalesForceLogIn {
    private WebDriver webDriver;
    private String url;
    private By userName;
    private By userPassword;
    private By logInButton;

    /**
     * Constructor.
     * @param webDriver instance.
     * @param url the page.
     */
    public SalesForceLogIn(final WebDriver webDriver, final String url) {
        this.webDriver = webDriver;
        this.url = url;
        this.userName = By.id("username");
        this.userPassword = By.id("password");
        this.logInButton = By.id("Login");
    }

    /**
     * Setter of url attribute.
     */
    public void setWebDriverUrl() {
        this.webDriver.get(this.url);
    }

    /**
     * Setter of userName attribute.
     * @param userName string value.
     */
    public void setUserName(final String userName) {
        webDriver.findElement(this.userName).sendKeys(userName);
    }

    /**
     * Setter of userPassword attribute.
     * @param userPassword string value.
     */
    public void setUserPassword(final String userPassword) {
        webDriver.findElement(this.userPassword).sendKeys(userPassword);
    }

    /**
     * Getter of logInbutton.
     * @return the button.
     */
    public WebElement getLogInButton() {
        return webDriver.findElement(logInButton);
    }

    /**
     * Method to click logInButton.
     * @param button to click.
     */
    public void clickLogInButton(final WebElement button) {
        button.click();
    }

    /**
     * Method to log in Salesforce.
     * @param user the user.
     * @param pass its password.
     */
    public void logIn(final String user, final String pass) {
        setWebDriverUrl();
        this.setUserName(user);
        this.setUserPassword(pass);
        WebElement button = getLogInButton();
        clickLogInButton(button);
    }
}

