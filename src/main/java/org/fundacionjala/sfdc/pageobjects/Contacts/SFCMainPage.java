package org.fundacionjala.sfdc.pageobjects.Contacts;

import org.fundacionjala.sfdc.commons.DriverManager;
import org.fundacionjala.sfdc.pageobjects.SalesForceConnection;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SFCMainPage extends SalesForceConnection {
    private WebDriverWait wait;

    @FindBy(how = How.CSS, using = "input[name='new']")
    private WebElement newContactButton;

    @FindBy(how = How.CSS, using = "tr.dataRow.even.first.dataRow >th[scope='row'] > a")
    private WebElement lastContactLink;

    @FindBy(how = How.CSS, using = "h2.pageDescription")
    private WebElement homeContact;


    /**
     * Constructor.
     */
    public SFCMainPage() {
        super();
        PageFactory.initElements(this.webDriver, this);
    }

    /**
     * Method to do click "new" button.
     * @return a new contact button element.
     */
    public WebElement getNewButton() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOf(this.newContactButton));
        return this.newContactButton;
    }
    /**
     * Method to get the last concat name link.
     * @return the last contact.
     */
    public WebElement getContactNameLink() {

        return this.lastContactLink;
    }

    /**
     * Method to know if an account was delete.
     * @return the contact home page.
     */
    public String contactHomePage() {
        wait = DriverManager.getInstance().getWaiter();
        wait.until(ExpectedConditions.visibilityOf(this.homeContact));
        return this.homeContact.getText();
    }

    /**
     * Method to do click "new" button.
     */
    public void clickNewButton() {
        getNewButton().click();

    }

    /**
     * Method to do click "contactHomePage".
     */
    public void clickContactNameLink() {
        getContactNameLink().click();
    }

}
