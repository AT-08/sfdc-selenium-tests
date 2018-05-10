package org.fundacionjala.sfdc.pageobjects;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.fundacionjala.sfdc.commons.DriverManager;

/**
 * SalesForceAccounts.java
 * Class that represents Accounts page in SalesForce.
 */
public class SalesForceContacts {
    private WebDriver webDriver;
    private By contactNameTextField;
    private By newContactButton;
    private WebDriverWait wait;

    /**
     * Constructor.
     * @param webDriver instance.
     */
    public SalesForceContacts(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.contactNameTextField = By.cssSelector("input[placeholder='First Name']");
        this.newContactButton = By.cssSelector("a[title='New']");
    }



    public void clickNewButton(final WebElement button) {
        button.click();
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOfElementLocated(this.contactNameTextField));
    }

    public WebElement getNewButton() {
        return this.webDriver.findElement(this.newContactButton);
    }




}

