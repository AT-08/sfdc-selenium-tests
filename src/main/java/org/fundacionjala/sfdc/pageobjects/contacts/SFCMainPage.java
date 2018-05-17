package org.fundacionjala.sfdc.pageobjects.contacts;

import org.fundacionjala.sfdc.pageobjects.BasePage;
import org.fundacionjala.sfdc.util.CommonActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
/**
 * SFCMainPage.java
 * Class that represents the main page of contacts section.
 */
public class SFCMainPage extends BasePage {

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

        return CommonActions.getElement(this.newContactButton);
    }
    /**
     * Method to get the last concat name link.
     * @return the last contact.
     */
    public WebElement getContactNameLink() {

        return CommonActions.getElement(this.lastContactLink);
    }

    /**
     * Method to know if an account was delete.
     * @return the contact home page.
     */
    public String contactHomePage() {
        return CommonActions.getElement(this.homeContact).getText();
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
