package org.fundacionjala.sfdc.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * CreateContacts.java.
 * Class that represents the page create contacts in SalesForce.
 */
public class CreateContacts {
    private By firstName;
    private By lastName;
    private By saveButton;
    private WebElement element;

    /**
     * Constructor.
     * @param element is a webelement.
     */
    public CreateContacts(final WebElement element) {
        this.element = element;
        this.firstName = By.xpath("//input[@class='firstName']");
        this.lastName = By.xpath("//input[@class='lastName']");
        this.saveButton = By.xpath("//input[@title='Save']");

    }

    /**
     * Setter of firtName attribute.
     * @param firstName attribute.
     */
    public void setFirstName(final String firstName) {
        element.findElement(this.firstName).sendKeys(firstName);
    }

    /**
     * Setter of lastName attribute.
     * @param lastName attribute.
     */
    public void setLastName(final String lastName) {
        element.findElement(this.lastName).sendKeys(lastName);
    }

    /**
     * Getter of saveButton attribute.
     * @return element.
     */
    public WebElement getSaveButton() {
        return element.findElement(saveButton);
    }

    /**
     * Method to click button.
     * @param button to click.
     */
    public void clickSaveButton(final WebElement button) {
        button.click();
    }

    /**
     * Method that creates a new contact.
     * @param firstName of contanct.
     * @param lastName of contact.
     */
    public void creation(final String firstName, final String lastName) {
        this.setFirstName(firstName);
        this.setLastName(lastName);
        WebElement button = getSaveButton();
        clickSaveButton(button);
    }
}

